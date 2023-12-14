package com.example.wthrapp.ui.addCity

import android.content.Context
import com.example.wthrapp.ui.base.BaseContract

interface AddCityContract {
    interface View : BaseContract.View {
        fun closeFragment()
    }

    interface Presenter : BaseContract.Presenter<View> {
        fun saveContext(context: Context)
        fun addCity(city: String)

    }
}