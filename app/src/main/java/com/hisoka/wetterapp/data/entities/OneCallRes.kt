package com.hisoka.wetterapp.data.entities


import androidx.room.*
import com.google.gson.annotations.SerializedName

@Entity(tableName="one_call")
data class OneCallRes(
								@PrimaryKey(autoGenerate = true) val id:Long,
								val resDate:Long=System.currentTimeMillis(),
								val current : WeatherApiRes,
								val daily : List<Daily>,
								val hourly : List<Hourly>,
								val lat : Double, // 44.8023
								val lon : Double, // -0.3378
								val timezone : String, // Europe/Paris
								@SerializedName("timezone_offset")
								val timezoneOffset : Int // 7200
)

