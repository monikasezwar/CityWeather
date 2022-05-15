package com.example.cityweather.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClientInstance {

    lateinit var retrofit: Retrofit
    private val BASE_URL = "https://api.openweathermap.org/data/2.5/"

    fun getRetrofitInstance(): Retrofit {
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit
    }
}