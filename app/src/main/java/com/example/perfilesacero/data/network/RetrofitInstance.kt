package com.example.perfilesacero.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://www.banxico.org.mx/SieAPIRest/service/v1/"

    val api: BanxicoApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BanxicoApiService::class.java)
    }
}
