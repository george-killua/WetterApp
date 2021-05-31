package com.hisoka.wetterapp.data.weather_res


import com.google.gson.annotations.SerializedName

data class WeatherResponseOneCall(
    val current: Current,
    val daily: List<Daily>,
    val hourly: List<Hourly>,
    val lat: Double, // 33.44
    val lon: Double, // -94.04
    val timezone: String, // America/Chicago
    @SerializedName("timezone_offset")
    val timezoneOffset: Long // -18000
)