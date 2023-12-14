package com.example.wthrapp.ui.entity

import com.google.gson.annotations.SerializedName

data class WeatherInfoResponse(
    @SerializedName("cod")
    val cod: Int,
    @SerializedName("weather")
    val weather: List<Weather>,
    @SerializedName("main")
    val main: Main,
    @SerializedName("visibility")
    val visibility: Int,
    @SerializedName("wind")
    val wind: Wind,
    @SerializedName("clouds")
    val clouds: Clouds,
    @SerializedName("sys")
    val sys: Sys,
    @SerializedName("dt")
    val dt: Long,
    @SerializedName("name")
    val name: String,
)
