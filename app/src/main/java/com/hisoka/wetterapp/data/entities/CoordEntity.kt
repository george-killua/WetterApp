package com.hisoka.wetterapp.data.entities

import com.google.gson.annotations.*

data class CoordEntity(
				@Expose
				@SerializedName("lon")
				val lon : Double,
				@Expose
				@SerializedName("lat")
				val lat : Double)