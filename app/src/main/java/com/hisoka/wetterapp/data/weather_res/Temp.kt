package com.hisoka.wetterapp.data.weather_res


import com.google.gson.annotations.SerializedName

data class Temp(
    val day: Double, // 290.48
    val eve: Double, // 295.01
    val max: Double, // 296.45
    val min: Double, // 282.6
    val morn: Double, // 284.16
    val night: Double // 288.01
)