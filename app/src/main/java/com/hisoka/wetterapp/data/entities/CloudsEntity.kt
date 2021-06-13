package com.hisoka.wetterapp.data.entities

import com.google.gson.annotations.*

data class CloudsEntity(
				@Expose
				@SerializedName("all")
				val all : Int)