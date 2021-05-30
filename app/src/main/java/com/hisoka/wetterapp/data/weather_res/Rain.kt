package com.hisoka.wetterapp.data.weather_res


import com.google.gson.annotations.SerializedName

data class Rain(
    @SerializedName("1h")
    val h: Double // 0.3
)