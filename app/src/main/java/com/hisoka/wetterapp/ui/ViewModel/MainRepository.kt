package com.hisoka.wetterapp.ui.ViewModel

import android.content.Context
import androidx.lifecycle.LiveData
import com.hisoka.wetterapp.data.entities.*
import com.hisoka.wetterapp.data.localdata.*
import com.hisoka.wetterapp.data.networking.WeatherApiImpl

class MainRepository(private val cityDao : CityDao,
                     private val weatherCurrentDau : WeatherCurrentDau,
                     private val weatherOneCallDao : WeatherOneCallDao,
                     context : Context
) {

				//api services init
				val apiService by lazy { WeatherApiImpl() }

				//get fun's
				val dbAllCities by lazy { cityDao.all() }
				val dbGetWeatherCurrent = weatherCurrentDau.getAllWeatherRes()
				fun dbGetWeatherCurrent(coord:CoordEntity) = weatherCurrentDau.getAllWeatherResWithlatlon(coord)
				val dbGetWeatherOneCall = weatherOneCallDao.getAllWeatherRes()
				fun dbGetWeatherOneCallWithId (coord : CoordEntity) : LiveData<List<OneCallRes>> {
							val	id=coord.lon+coord.lat
						return		weatherOneCallDao.getAllWeatherResWithID(id)
				}
				fun apiGetWeatherCurrent(lat : Double, lon : Double) =
								apiService.getCurrentWeather(lat, lon)

				fun apiGetWeatherOneCall(lat : Double, lon : Double) = apiService.getOneCalWeather(lat, lon)

				//inserts fun's
				suspend fun insertCurrentWeather(vararg current : WeatherApiRes) =
								weatherCurrentDau.addWeatherRes(
												*current
								)

				suspend fun insertOneCallWeather(vararg current : OneCallRes) =
								weatherOneCallDao.addWeatherRes(
												*current
								)



				//delete fun's
				suspend fun deleteCurrentWeather(current : WeatherApiRes) = weatherCurrentDau
								.deleteWeatherRes(current)
				fun deleteAllCurrentWeather() = weatherCurrentDau.deleteAllWeatherRes()

				suspend fun deleteOneCallWeather(oneCall : OneCallRes) = weatherOneCallDao
								.deleteWeatherRes(oneCall)
				fun deleteAllOneCallWeather() = weatherOneCallDao.deleteAllWeatherRes()


}