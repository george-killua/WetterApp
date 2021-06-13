package com.hisoka.wetterapp.data.localdata

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteDatabase
import com.hisoka.wetterapp.data.*
import com.hisoka.wetterapp.data.entities.*
import kotlinx.coroutines.*

@Database(
				entities = [WeatherApiRes::class, OneCallRes::class, City::class],
				version = 1, exportSchema = false
)
@TypeConverters(
				CoordEntityConverters::class,
				WeatherCurrentConverter::class,
				WeatherEntityConverter::class,
				MainEntityConverters::class,
				WindEntityConverters::class,
				CloudsEntityConverters::class,
				SysEntityConverters::class,
				DailyEntityConverter::class,
				HourlyEntityConverter::class,
				WeatherCurrentEntityConverters::class
)


abstract class DatabaseStructure : RoomDatabase() {

				abstract fun cityDao() : CityDao

				abstract fun weatherDau() : WeatherCurrentDau
				abstract fun oneCallWeatherDau() : WeatherOneCallDao

				class MyDatabaseCallback(
												private val scope : CoroutineScope
				) : RoomDatabase.Callback() {

								override fun onCreate(db : SupportSQLiteDatabase) {
												super.onCreate(db)
												INSTANCE?.let { _ ->
																scope.launch {
																				populateDatabase()
																}

												}
								}

								suspend fun populateDatabase() {
												// Delete all content here.

												INSTANCE?.let {
																scope.launch {
																				if (it.cityDao().citySize == 0) it.cityDao().insertAll(
																								*Utilities.getCitiesFromJSON
																												(context!!).toTypedArray()
																				)
																}
												}

								}
				}

				companion object {
								var INSTANCE : DatabaseStructure? = null
								var context : Context? = null
								fun getDatabase(
																context : Context,
																scope : CoroutineScope
								) : DatabaseStructure {
												this.context = context
												return INSTANCE ?: synchronized(this) {
																val instance = Room.databaseBuilder(
																				context.applicationContext,
																				DatabaseStructure::class.java,
																				DatabaseStructure::javaClass.name
																).addCallback(MyDatabaseCallback(scope)).allowMainThreadQueries().build()
																INSTANCE = instance
																instance

												}
								}
				}

}
