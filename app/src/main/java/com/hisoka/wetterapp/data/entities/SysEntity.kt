package com.hisoka.wetterapp.data.entities

import com.google.gson.annotations.*

data class SysEntity(
				@Expose
				@SerializedName("type")
				val type : Int,
				@Expose
				@SerializedName("id")
				val id : Int,
				@Expose
				@SerializedName("message")
				val message : Double,
				@Expose
				@SerializedName("country")
				val country : String,
				@Expose
				@SerializedName("sunrise")
				val sunrise : Int,
				@Expose
				@SerializedName("sunset")
				val sunset : Int)