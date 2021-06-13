package com.hisoka.wetterapp.data.entities

import com.google.gson.annotations.*

data class WeatherEntity(
				@Expose
				@SerializedName("id")
				val id : Int,
				@Expose
				@SerializedName("main")
				val main : String,
				@Expose
				@SerializedName("description")
				val description : String,
				@Expose
				@SerializedName("icon")
				val icon : String)