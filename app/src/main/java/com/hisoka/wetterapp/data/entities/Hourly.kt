package com.hisoka.wetterapp.data.entities

import com.google.gson.annotations.SerializedName


data class Hourly(
								val clouds: Int, // 0
								@SerializedName("dew_point")
        val dewPoint: Double, // 289.72
								val dt: Int, // 1623600000
								@SerializedName("feels_like")
        val feelsLike: Double, // 306.65
								val humidity: Int, // 37
								val pop: Int, // 0
								val pressure: Int, // 1018
								val temp: Double, // 306.37
								val uvi: Double, // 3.04
								val visibility: Int, // 10000
								val weather: List<WeatherEntity>,
								@SerializedName("wind_deg")
        val windDeg: Int, // 27
								@SerializedName("wind_gust")
        val windGust: Double, // 2.28
								@SerializedName("wind_speed")
        val windSpeed: Double // 2.07
    )