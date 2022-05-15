package com.example.cityweather.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cityweather.common.Constants
import com.example.cityweather.model.WeatherResponse
import com.example.cityweather.network.CityWeatherService
import com.example.cityweather.network.RetrofitClientInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class CityViewModel: ViewModel(){

    private val TAG = CityViewModel::class.java.simpleName
    internal var weatherResponse = MutableLiveData<WeatherResponse>()

    fun getCityWeather(city: String): LiveData<WeatherResponse?>{
        getCityWeatherFromServer(city)
        return weatherResponse
    }

   private fun getCityWeatherFromServer(city: String){
        val service = RetrofitClientInstance.getRetrofitInstance().create(CityWeatherService::class.java)
        val call = service.getCityWeather(city, Constants.API_KEY)

        call.enqueue(object: Callback<WeatherResponse>{
            override fun onResponse(
                call: Call<WeatherResponse>,
                response: Response<WeatherResponse>
            ) {
               if(response != null && response.isSuccessful){
                   weatherResponse.postValue(response.body())
               }else{

                   weatherResponse.postValue(null)
                   Log.i(TAG,"Server Error")
               }
            }

            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                weatherResponse.postValue(null)
                Log.i(TAG,"Something went wrong...Please try later!")
            }

        })
    }
}


