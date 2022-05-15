package com.example.cityweather.network

import com.example.cityweather.model.WeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CityWeatherService {

    @GET("weather?")
    fun getCityWeather(@Query("q") cityName: String,@Query("appid") api: String): Call<WeatherResponse>
}