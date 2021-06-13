package com.hisoka.wetterapp.data.networking

import com.hisoka.wetterapp.data.entities.*
import okhttp3.*
import okhttp3.internal.notify
import retrofit2.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory

class WeatherApiImpl  {
				 fun getCurrentWeather(lat : Double,
				                               lon : Double, )=
								api.getCurrentWeather(lat, lon)


				 fun getOneCalWeather(lat : Double,
				                              lon : Double) =
								api.getOneCalWeather(lat, lon)

				init {
								instant = this
				}

				companion object {
								var instant : WeatherApiImpl? = WeatherApiImpl()

								const val id = "e0de9110207141802e056c53709cac21"
								private val client = OkHttpClient.Builder().addInterceptor {
												var request = it.request()
												val url : HttpUrl = request.url.newBuilder().addQueryParameter("appid", id).build()
												request = request.newBuilder().url(url).build()
												it.proceed(request)
								}.build()

								var api : WeatherApi = Retrofit.Builder()
												.baseUrl("https://api.openweathermap.org/data/2.5/")
												.addConverterFactory(GsonConverterFactory.create())
												.client(client)
												.build()
												.create(WeatherApi::class.java)


				}
}