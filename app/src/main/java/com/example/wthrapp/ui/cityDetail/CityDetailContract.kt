package com.example.wthrapp.ui.cityDetail

import com.example.wthrapp.ui.base.BaseContract
import com.example.wthrapp.ui.entity.WeatherInfoResponse
import com.example.wthrapp.ui.main.MainContract

interface CityDetailContract {
    interface View : BaseContract.View {
        fun setData(data: WeatherInfoResponse)
    }

    interface Presenter : BaseContract.Presenter<CityDetailContract.View> {
        fun getWeather(cityName: String)
    }
}