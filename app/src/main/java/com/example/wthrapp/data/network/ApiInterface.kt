package com.example.wthrapp.data.network

import com.example.wthrapp.ui.entity.WeatherInfoResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("weather")
    fun getWeather(@Query("q") cityName: String): Call<WeatherInfoResponse>
}