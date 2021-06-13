package com.hisoka.wetterapp.data.entities

import androidx.room.*
import com.google.gson.annotations.*
import com.hisoka.wetterapp.data.*

@Entity(tableName = "weather_res")
data class WeatherApiRes(
								@Expose
								@SerializedName("coord")
								val coord : CoordEntity,
								@Expose
								@SerializedName("weather")
								val weatherEntity : List<WeatherEntity>,
								@Expose
								@SerializedName("base")
								val base : String?,
								@Expose
								@SerializedName("main")
								val main : MainEntity,
								@Expose
								@SerializedName("visibility")
								val visibility : Int,
								@Expose
								@SerializedName("wind")
								val wind : WindEntity,
								@Expose
								@SerializedName("clouds")
								val clouds : CloudsEntity,
								@Expose
								@SerializedName("dt")
								val date : Long,
								@Expose
								@SerializedName("sys")
								val sys : SysEntity,
								@Expose
								@SerializedName("timezone")
								val timezone : Int,
								@Expose
								@SerializedName("id")
								@PrimaryKey()
								val id : Int,
								@Expose
								@SerializedName("name")
								val name : String,
								@Expose
								@SerializedName("cod")
								val cod : Int
)

