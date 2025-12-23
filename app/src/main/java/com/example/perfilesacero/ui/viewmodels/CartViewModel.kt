package com.example.perfilesacero.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.perfilesacero.data.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CartViewModel : ViewModel() {

    private val _cartItems = MutableStateFlow<List<Product>>(emptyList())
    val cartItems: StateFlow<List<Product>> = _cartItems.asStateFlow()

    fun addToCart(product: Product) {
        // Check if the product is already in the cart to avoid duplicates
        if (!_cartItems.value.any { it.id == product.id }) {
            _cartItems.value = _cartItems.value + product
        }
    }

    fun removeFromCart(product: Product) {
        _cartItems.value = _cartItems.value.filterNot { it.id == product.id }
    }
}
