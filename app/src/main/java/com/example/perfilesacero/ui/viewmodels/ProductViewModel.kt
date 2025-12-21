package com.example.perfilesacero.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.perfilesacero.data.DatabaseProvider
import com.example.perfilesacero.data.ProductDao
import com.example.perfilesacero.data.ProductEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class ProductViewModel(application: Application) : AndroidViewModel(application) {

    private val productDao: ProductDao

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
}
