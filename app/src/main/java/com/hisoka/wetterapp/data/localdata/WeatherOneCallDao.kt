package com.hisoka.wetterapp.data.localdata

import androidx.lifecycle.LiveData
import androidx.room.*
import com.hisoka.wetterapp.data.entities.OneCallRes


@Dao
interface WeatherOneCallDao {
				@Query("select * from one_call order by resDate desc")
				fun getAllWeatherRes(): LiveData<List<OneCallRes>>
				@Query("select * from one_call where id =:id ")
				fun getAllWeatherResWithID(id : Double,): LiveData<List<OneCallRes>>


				@Insert(onConflict = OnConflictStrategy.REPLACE)
				suspend fun addWeatherRes(vararg weatherRes: OneCallRes)


				@Delete
				suspend fun deleteWeatherRes(weatherRes: OneCallRes)

				@Query("DELETE FROM one_call")
				fun deleteAllWeatherRes()


}

