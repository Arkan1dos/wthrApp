package com.example.wthrapp.ui.main

import android.content.Context
import com.example.wthrapp.ui.base.BaseContract
import com.example.wthrapp.ui.entity.WeatherInfoResponse

interface MainContract {
    interface View : BaseContract.View {
        fun setData(response: List<WeatherInfoResponse>)
        fun onRemove()
    }

    interface Presenter : BaseContract.Presenter<View> {
        fun getWeathers(context: Context)
        fun removeCities(context: Context)
    }
}