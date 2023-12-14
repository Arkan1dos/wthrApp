package com.example.wthrapp.ui.main

import android.content.Context
import com.example.wthrapp.common.RequestCompleteListener
import com.example.wthrapp.data.repository.HourlyWeatherRepository
import com.example.wthrapp.data.repository.HourlyWeatherRepositoryImpl
import com.example.wthrapp.ui.base.BasePresenter
import com.example.wthrapp.ui.entity.WeatherInfoResponse
import com.example.wthrapp.utils.getSavedPref
import com.example.wthrapp.utils.saveToPref

class MainPresenter : BasePresenter<MainContract.View>(), MainContract.Presenter {

    private lateinit var weatherRepository: HourlyWeatherRepository

    var listResponse = mutableListOf<WeatherInfoResponse>()

    override fun onAttach(view: MainContract.View) {
        super.onAttach(view)
        weatherRepository = HourlyWeatherRepositoryImpl()
    }

    override fun getWeathers(context: Context) {
        listResponse.clear()
        val cities = getSavedPref(context)
        if (cities.isNotEmpty()) {
            cities.forEach {
                getCityWeather(it, cities.size)
            }
        } else {
            view?.setData(emptyList())
        }
    }

    override fun removeCities(context: Context) {
        saveToPref(context, listOf())
        view?.onRemove()
    }

    private fun getCityWeather(city: String, size: Int) {
        weatherRepository.getWeather(city, object :
            RequestCompleteListener<WeatherInfoResponse> {
            override fun onRequestSuccess(data: WeatherInfoResponse) {
                listResponse.add(data)
                if (listResponse.size == size) {
                    view?.setData(listResponse)
                }
            }

            override fun onRequestFailed(errorMessage: String) {
            }
        })
    }
}