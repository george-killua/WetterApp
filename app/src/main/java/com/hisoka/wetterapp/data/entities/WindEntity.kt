package com.hisoka.wetterapp.data.entities

import com.google.gson.annotations.*

data class WindEntity(
				@Expose
				@SerializedName("speed")
				val speed : Double,
				@Expose
				@SerializedName("deg")
				val deg : Int)