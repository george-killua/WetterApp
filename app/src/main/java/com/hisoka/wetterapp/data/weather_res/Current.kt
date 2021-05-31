package com.hisoka.wetterapp.data.weather_res


import com.google.gson.annotations.SerializedName

data class Current(
    val clouds: Int, // 4
    @SerializedName("dew_point")
    val dewPoint: Double, // 283.7
    val dt: Int, // 1622390290
    @SerializedName("feels_like")
    val feelsLike: Double, // 287.8
    val humidity: Int, // 74
    val pressure: Int, // 1023
    val sunrise: Int, // 1622372885
    val sunset: Int, // 1622423986
    val temp: Double, // 288.3
    val uvi: Double, // 6.44
    val visibility: Int, // 10000
    val weather: List<Weather>,
    @SerializedName("wind_deg")
    val windDeg: Int, // 42
    @SerializedName("wind_gust")
    val windGust: Double, // 4.02
    @SerializedName("wind_speed")
    val windSpeed: Double // 1.79
)