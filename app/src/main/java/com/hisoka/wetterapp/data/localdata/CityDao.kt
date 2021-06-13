package com.hisoka.wetterapp.data.localdata

import androidx.lifecycle.LiveData
import androidx.room.*
import com.hisoka.wetterapp.data.entities.City

@Dao
interface CityDao {
				@Query("SELECT * FROM city")
				fun all (): LiveData<City>?
				@get:Query("SELECT COUNT(*) FROM city")
				val citySize : Int

				@Insert
				suspend		fun insertAll(vararg cities : City)

}