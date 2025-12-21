package com.example.perfilesacero.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.perfilesacero.data.DatabaseProvider
import com.example.perfilesacero.data.ProductDao
import com.example.perfilesacero.data.ProductEntity
import com.example.perfilesacero.data.network.RetrofitInstance
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductViewModel(application: Application) : AndroidViewModel(application) {

    private val productDao: ProductDao

    private val _exchangeRate = MutableStateFlow<String?>(null)
    val exchangeRate: StateFlow<String?> = _exchangeRate

    init {
        val database = DatabaseProvider.getDatabase(application)
        productDao = database.productDao()
    }

    val allProducts: Flow<List<ProductEntity>> = productDao.getAllProducts()

    fun addProduct(name: String, description: String) {
        viewModelScope.launch {
            productDao.insertProduct(ProductEntity(name = name, description = description))
        }
    }

    fun fetchExchangeRate(token: String) {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getExchangeRate(token = token)
                val rate = response.bmx.series.firstOrNull()?.datos?.firstOrNull()?.dato
                _exchangeRate.value = rate
            } catch (e: Exception) {
                // Handle error
                _exchangeRate.value = "Error"
            }
        }
    }
}
