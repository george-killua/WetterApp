package com.hisoka.wetterapp.data.localdata

import androidx.lifecycle.LiveData
import androidx.room.*
import com.hisoka.wetterapp.data.entities.*
import kotlinx.coroutines.flow.Flow
@Dao
interface WeatherCurrentDau {
				@Query("select * from weather_res order by date desc")
				fun getAllWeatherRes(): LiveData<List<WeatherApiRes>>

				@Query("select * from weather_res where coord =:coord order by date desc")
				fun getAllWeatherResWithlatlon(coord:CoordEntity): LiveData<List<WeatherApiRes>>


				@Insert(onConflict = OnConflictStrategy.REPLACE)
				suspend fun addWeatherRes(vararg weatherRes: WeatherApiRes)
				@Delete
				suspend fun deleteWeatherRes(weatherRes: WeatherApiRes)

				@Query("DELETE FROM weather_res")
				fun deleteAllWeatherRes()
}
