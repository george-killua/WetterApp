package com.hisoka.wetterapp.data.entities

import androidx.room.*
import com.google.gson.annotations.*
import com.hisoka.wetterapp.data.CoordEntityConverters
import com.hisoka.wetterapp.data.entities.CoordEntity

@Entity(tableName="city")
data class City(
								@Expose
								@SerializedName("coord")
								val coord : CoordEntity,
								@Expose
								@SerializedName("country")
								val country : String, // IR
								@Expose
								@SerializedName("id")
								@PrimaryKey	val id : Int, // 833
								@Expose
								@SerializedName("name")
								val name : String, // Ḩeşār-e Sefīd
								@Expose
								@SerializedName("state")
								val state : String
)