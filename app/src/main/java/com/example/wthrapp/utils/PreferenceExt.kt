package com.example.wthrapp.utils

import android.content.Context
import com.example.wthrapp.R
import com.google.gson.Gson

const val CITY_LIST = "CITY_LIST"

fun saveToPref(context: Context, cities: List<String>) {
    val pref = context.getSharedPreferences(
        context.getString(R.string.preference_file_key),
        Context.MODE_PRIVATE
    )
    val editor = pref.edit()
    val gson = Gson()
    val jsonFavorites = gson.toJson(cities)
    editor.putString(CITY_LIST, jsonFavorites)
    editor.apply()
}

fun getSavedPref(context: Context): List<String> {
    val pref = context.getSharedPreferences(
        context.getString(R.string.preference_file_key),
        Context.MODE_PRIVATE
    )
    var cities: List<String>
    if (pref.contains(CITY_LIST)) {
        val jsonFavorites: String = pref.getString(CITY_LIST, "")!!
        val gson = Gson()
        val favoriteItems = gson.fromJson(
            jsonFavorites,
            Array<String>::class.java
        )
        cities = favoriteItems.asList()
    } else {
        return ArrayList()
    }
    return cities
}