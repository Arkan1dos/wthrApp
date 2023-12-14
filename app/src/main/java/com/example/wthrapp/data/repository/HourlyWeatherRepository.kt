package com.example.wthrapp.data.repository

import com.example.wthrapp.common.RequestCompleteListener
import com.example.wthrapp.ui.entity.WeatherInfoResponse

interface HourlyWeatherRepository {
    fun getWeather(cityName: String, callback: RequestCompleteListener<WeatherInfoResponse>)
}