package com.hisoka.wetterapp.data.entities

import com.google.gson.annotations.*

data class MainEntity(
				@Expose
				@SerializedName("temp")
				val temp : Double,
				@Expose
				@SerializedName("feels_like")
				val feelsLike : Double,
				@Expose
				@SerializedName("temp_min")
				val tempMin : Double,
				@Expose
				@SerializedName("temp_max")
				val tempMax : Double,
				@Expose
				@SerializedName("pressure")
				val pressure : Int,
				@Expose
				@SerializedName("humidity")
				val humidity : Int)