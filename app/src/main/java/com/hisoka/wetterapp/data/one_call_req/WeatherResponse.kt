package com.hisoka.wetterapp.data.one_call_req

import com.hisoka.wetterapp.data.weather_res.Weather


data class WeatherResponse(
    val base: String, // stations
    val clouds: Clouds,
    val cod: Int, // 200
    val coord: Coord,
    val dt: Int, // 1622390883
    val id: Int, // 4133367
    val main: Main,
    val name: String, // Texarkana
    val sys: Sys,
    val timezone: Int, // -18000
    val visibility: Int, // 10000
    val weather: List<Weather>,
    val wind: Wind
)