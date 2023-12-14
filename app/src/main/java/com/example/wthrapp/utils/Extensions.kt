package com.example.wthrapp.utils

import java.text.SimpleDateFormat
import java.util.*

fun Long.millisToDate(): String {
    val formatter = SimpleDateFormat("dd.MM.yyyy HH:mm");
    return formatter.format(Date(this * 1000))
}

fun Long.millisToDateHHMM(): String {
    val formatter = SimpleDateFormat("HH:mm");
    return formatter.format(Date(this * 1000))
}

fun Float.kelvinToCelsius() : String {
    val result = (this - 273.15).toInt()
    return "$result°C"
}

fun Int.withPercent() : String{
    return "$this%"
}

fun Float.toMS() : String {
    return "$this m/s"
}