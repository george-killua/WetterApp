package com.hisoka.wetterapp

import android.app.Application
import com.hisoka.wetterapp.data.localdata.DatabaseStructure
import com.hisoka.wetterapp.ui.ViewModel.MainRepository
import kotlinx.coroutines.*

class MyApplication : Application() {
				private var databaseStructure : DatabaseStructure? = null
				private val applicationScope = CoroutineScope(SupervisorJob())
				override fun onCreate() {
								super.onCreate()
								databaseStructure = DatabaseStructure.getDatabase(this, applicationScope)
				}

				val repository by lazy {
								if (databaseStructure == null) {
												databaseStructure = DatabaseStructure.getDatabase(this, applicationScope)
								}
								MainRepository(
												databaseStructure!!.cityDao(),
												databaseStructure!!.weatherDau(),
												databaseStructure!!.oneCallWeatherDau(),
												context = applicationContext!!
								)
				}
}
