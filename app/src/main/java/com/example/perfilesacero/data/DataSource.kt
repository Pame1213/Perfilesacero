package com.example.perfilesacero.data

import androidx.annotation.DrawableRes
import com.example.perfilesacero.R

// Data class to hold our product information
data class Product(val id: String, val name: String, @DrawableRes val imageRes: Int)

// Static list of products
val productList = listOf(
    Product("placa", "PLACA EN HOJA Y ROLLO", R.drawable.placa_en_hoja_y_rollo),
    Product("lamina", "LÁMINA ROLADA EN CALIENTE", R.drawable.lamina_rolada_en_caliente),
    Product("angulo", "ÁNGULO", R.drawable.angulo),
    Product("canal", "CANAL C.P.S.", R.drawable.canal_cps),
    Product("cemento", "CEMENTO HOLCIM", R.drawable.cemento_holcim)
)
