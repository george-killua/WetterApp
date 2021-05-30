package com.hisoka.wetterapp.data.one_call_req


import com.google.gson.annotations.SerializedName

data class Main(
    @SerializedName("feels_like")
    val feelsLike: Double, // 288.19
    val humidity: Int, // 73
    val pressure: Int, // 1024
    val temp: Double, // 288.68
    @SerializedName("temp_max")
    val tempMax: Double, // 291.82
    @SerializedName("temp_min")
    val tempMin: Double // 288.13
)