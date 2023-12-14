package com.example.wthrapp.ui.addCity

import android.content.Context
import com.example.wthrapp.ui.base.BasePresenter
import com.example.wthrapp.utils.getSavedPref
import com.example.wthrapp.utils.saveToPref


class AddCityPresenter : BasePresenter<AddCityContract.View>(), AddCityContract.Presenter {

    lateinit var context: Context

    override fun saveContext(context: Context) {
        this.context = context
    }

    override fun addCity(city: String) {
        val list = getSavedPref(context).toMutableList()
        list.add(city)
        saveToPref(context, list)
        view?.closeFragment()
    }
}