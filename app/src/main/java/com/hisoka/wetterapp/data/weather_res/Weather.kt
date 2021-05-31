package com.hisoka.wetterapp.data.weather_res


import com.google.gson.annotations.SerializedName

data class Weather(
    val description: String, // clear sky
    val icon: String, // 01d
    val id: Int, // 800
    val main: String // Clear
)