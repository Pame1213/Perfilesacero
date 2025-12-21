package com.example.perfilesacero.data.network

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface BanxicoApiService {
    @GET("series/{seriesId}/datos/oportuno")
    suspend fun getExchangeRate(
        @Path("seriesId") seriesId: String = "SF43718",
        @Header("Bmx-Token") token: String
    ): BanxicoResponse
}
