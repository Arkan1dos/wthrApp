package com.example.wthrapp.data.repository

import com.example.wthrapp.common.RequestCompleteListener
import com.example.wthrapp.data.network.ApiInterface
import com.example.wthrapp.data.network.RetrofitClient
import com.example.wthrapp.ui.entity.WeatherInfoResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HourlyWeatherRepositoryImpl : HourlyWeatherRepository {
    override fun getWeather(
        cityName: String, callback: RequestCompleteListener<WeatherInfoResponse>
    ) {
        val apiInterface: ApiInterface = RetrofitClient.client.create(ApiInterface::class.java)
        val call: Call<WeatherInfoResponse> = apiInterface.getWeather(cityName)

        call.enqueue(object : Callback<WeatherInfoResponse> {
            override fun onResponse(
                call: Call<WeatherInfoResponse>,
                response: Response<WeatherInfoResponse>
            ) {
                if (response.body() != null)
                    callback.onRequestSuccess(response.body()!!)
                else
                    callback.onRequestFailed(response.message())
            }

            override fun onFailure(call: Call<WeatherInfoResponse>, t: Throwable) {
                callback.onRequestFailed(t.localizedMessage!!)
            }

        })
    }
}