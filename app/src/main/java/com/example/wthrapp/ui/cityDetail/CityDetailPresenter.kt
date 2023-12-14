package com.example.wthrapp.ui.cityDetail

import com.example.wthrapp.common.RequestCompleteListener
import com.example.wthrapp.data.repository.HourlyWeatherRepository
import com.example.wthrapp.data.repository.HourlyWeatherRepositoryImpl
import com.example.wthrapp.ui.base.BasePresenter
import com.example.wthrapp.ui.entity.WeatherInfoResponse
import com.example.wthrapp.ui.main.MainContract

class CityDetailPresenter : BasePresenter<CityDetailContract.View>(), CityDetailContract.Presenter {

    private lateinit var weatherRepository: HourlyWeatherRepository

    override fun onAttach(view: CityDetailContract.View) {
        super.onAttach(view)
        weatherRepository = HourlyWeatherRepositoryImpl()
    }

    override fun getWeather(cityName: String) {
        weatherRepository.getWeather(cityName, object :
            RequestCompleteListener<WeatherInfoResponse> {
            override fun onRequestSuccess(data: WeatherInfoResponse) {
                view?.setData(data)
            }

            override fun onRequestFailed(errorMessage: String) {
            }
        })
    }

}