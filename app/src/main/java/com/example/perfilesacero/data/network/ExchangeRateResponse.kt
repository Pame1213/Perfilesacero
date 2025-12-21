package com.example.perfilesacero.data.network

import com.google.gson.annotations.SerializedName

data class BanxicoResponse(
    val bmx: Bmx
)

data class Bmx(
    val series: List<Serie>
)

data class Serie(
    val idSerie: String,
    val titulo: String,
    val datos: List<Dato>
)

data class Dato(
    val fecha: String,
    val dato: String
)
