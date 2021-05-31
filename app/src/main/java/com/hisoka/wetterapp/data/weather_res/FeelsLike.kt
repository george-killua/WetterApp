package com.hisoka.wetterapp.data.weather_res


import com.google.gson.annotations.SerializedName

data class FeelsLike(
    val day: Double, // 290.02
    val eve: Double, // 295.08
    val morn: Double, // 283.64
    val night: Double // 287.72
)