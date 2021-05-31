package com.hisoka.wetterapp.data.weather_res


import com.google.gson.annotations.SerializedName

data class Hourly(
    val clouds: Int, // 4
    @SerializedName("dew_point")
    val dewPoint: Double, // 283.63
    val dt: Int, // 1622386800
    @SerializedName("feels_like")
    val feelsLike: Double, // 287.93
    val humidity: Int, // 73save api
    val pop: Int, // 0
    val pressure: Int, // 1023
    val rain: Rain,
    val temp: Double, // 288.44
    val uvi: Double, // 4.08
    val visibility: Int, // 10000
    val weather: List<Weather>,
    @SerializedName("wind_deg")
    val windDeg: Int, // 80
    @SerializedName("wind_gust")
    val windGust: Double, // 5.81
    @SerializedName("wind_speed")
    val windSpeed: Double // 4.28
)