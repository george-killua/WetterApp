package com.hisoka.wetterapp.data.networking

import com.hisoka.wetterapp.data.entities.*
import retrofit2.http.*

interface WeatherApi {

				@GET("weather")
				fun getCurrentWeather(
												@Query("lat") lat : Double,
												@Query("lon") lon : Double
				) : WeatherApiRes

				@GET("onecall")
				fun getOneCalWeather(
												@Query("lat") lat : Double,
												@Query("lon") lon : Double,
												@Query("exclude") minutely : String? = "minutely"
				) : OneCallRes
}

