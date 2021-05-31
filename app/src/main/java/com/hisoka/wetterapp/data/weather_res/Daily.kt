package com.hisoka.wetterapp.data.weather_res


import com.google.gson.annotations.SerializedName

data class Daily(
    val clouds: Int, // 4
    @SerializedName("dew_point")
    val dewPoint: Double, // 284.3
    val dt: Long, // 1622397600
    @SerializedName("feels_like")
    val feelsLike: FeelsLike,
    val humidity: Int, // 67
    @SerializedName("moon_phase")
    val moonPhase: Double, // 0.66
    val moonrise: Long, // 1622351280
    val moonset: Long, // 1622387820
    val pop: Int, // 0
    val pressure: Int, // 1023
    val rain: Double, // 6.66
    val sunrise: Long, // 1622372885
    val sunset: Long, // 1622423986
    val temp: Temp,
    val uvi: Double, // 9.36
    val weather: List<Weather>,
    @SerializedName("wind_deg")
    val windDeg: Int, // 78
    @SerializedName("wind_gust")
    val windGust: Double, // 10.88
    @SerializedName("wind_speed")
    val windSpeed: Double // 4.58
)