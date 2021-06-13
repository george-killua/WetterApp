package com.hisoka.wetterapp.ui.ViewModel

import androidx.lifecycle.*
import com.hisoka.wetterapp.MyApplication
import com.hisoka.wetterapp.data.Resource
import com.hisoka.wetterapp.data.entities.CoordEntity
import kotlinx.coroutines.*

class SharedViewModel : ViewModel() {

				val mainRepository by lazy {
								MyApplication().repository
				}
				val cities = liveData(Dispatchers.IO) {
								emit(Resource.loading((null)))
								kotlin.runCatching {
												emit(Resource.success(mainRepository.dbAllCities))
								}.getOrElse { Resource.error(null, "Error while Loading Cities") }
				}

				fun currentListDb() = liveData(Dispatchers.Unconfined) {
								emit(Resource.loading((null)))
								runBlocking {
												launch {
																kotlin.runCatching {
																				emit(Resource.success(mainRepository.dbGetWeatherCurrent))
																}.getOrElse { Resource.error(null, "Error while Loading Cities") }

												}
								}
				}
				fun currentWithCoord(coord : CoordEntity) = liveData(Dispatchers.Unconfined) {
								emit(Resource.loading((null)))
								runBlocking {
												launch {
																kotlin.runCatching {
																				val temp = Resource.success(mainRepository.dbGetWeatherCurrent(coord))
																				if (temp.data == null) {
																								val data = mainRepository.apiGetWeatherCurrent(coord.lat, coord.lon)
																								mainRepository.insertCurrentWeather(data)
																				}
																				else emit(Resource.success(temp))
																}.getOrElse { Resource.error(null, "Error while Loading Cities") }

												}
								}
				}
				fun oneCallListDb() = liveData(Dispatchers.Unconfined) {
								emit(Resource.loading((null)))
								runBlocking {
												launch {
																kotlin.runCatching {
																				emit(Resource.success(mainRepository.dbGetWeatherOneCall))
																}.getOrElse { Resource.error(null, "Error while Loading Cities") }

												}
								}
				}

				fun oneCallWithCoord(coord : CoordEntity) = liveData(Dispatchers.Unconfined) {
								emit(Resource.loading((null)))
								runBlocking {
												launch {
																kotlin.runCatching {
																				val temp = Resource.success(mainRepository.dbGetWeatherOneCallWithId(coord))
																				if (temp.data == null) {
																								val data = mainRepository.apiGetWeatherOneCall(coord.lat, coord.lon)
																								mainRepository.insertOneCallWeather(data)
																				}
																				else emit(Resource.success(temp))
																}.getOrElse { Resource.error(null, "Error while Loading Cities") }

												}
								}
				}
}
