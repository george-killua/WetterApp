package com.hisoka.wetterapp.data.entities

import com.google.gson.annotations.SerializedName

data class Daily(
								val clouds : Int, // 1
								@SerializedName("dew_point")
								val dewPoint : Double, // 287.75
								val dt : Int, // 1623585600
								@SerializedName("feels_like")
								val feelsLike : FeelsLike,
								val humidity : Int, // 37
								@SerializedName("moon_phase")
								val moonPhase : Double, // 0.09
								val moonrise : Int, // 1623565860
								val moonset : Int, // 0
								val pop : Int, // 0
								val pressure : Int, // 1021
								val rain : Double, // 4.05
								val sunrise : Int, // 1623557698
								val sunset : Int, // 1623613683
								val temp : Temp,
								val uvi : Double, // 8.96
								val weather : List<WeatherEntity>,
								@SerializedName("wind_deg")
								val windDeg : Int, // 14
								@SerializedName("wind_gust")
								val windGust : Double, // 8.14
								@SerializedName("wind_speed")
								val windSpeed : Double // 3.7
)


