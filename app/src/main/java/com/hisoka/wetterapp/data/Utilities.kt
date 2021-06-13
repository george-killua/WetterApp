package com.hisoka.wetterapp.data

import android.content.Context
import androidx.room.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.hisoka.wetterapp.data.entities.*
import java.io.IOException

object Utilities {
				fun resToString(listToString : List<WeatherApiRes>) : String {
								return Gson().toJson(listToString)
				}

				fun resFromString(resString : String) : List<WeatherApiRes> {
								return Gson().fromJson(resString, object : TypeToken<List<WeatherApiRes>>() {}.type)

				}

				fun getCitiesFromJSON(context : Context) : List<City> {
								val jsonFileString = getJsonDataFromAsset(context, "city.list.json")

								return Gson().fromJson(jsonFileString, object : TypeToken<List<City>>() {}.type)

				}

				fun getJsonDataFromAsset(context : Context, fileName : String) : String? {
								val jsonString : String
								try {
												jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
								}
								catch (ioException : IOException) {
												ioException.printStackTrace()
												return null
								}
								return jsonString
				}
}

@ProvidedTypeConverter
class WeatherEntityConverter {

				@TypeConverter
				fun fromCountryLangList(value : List<WeatherEntity>) : String {
								val gson = Gson()
								val type = object : TypeToken<List<WeatherEntity>>() {}.type
								return gson.toJson(value, type)
				}

				@TypeConverter
				fun toCountryLangList(value : String) : List<WeatherEntity> {
								val gson = Gson()
								val type = object : TypeToken<List<WeatherEntity>>() {}.type
								return gson.fromJson(value, type)
				}
}
@ProvidedTypeConverter
class DailyEntityConverter {

				@TypeConverter
				fun fromCountryLangList(value : List<Daily>) : String {
								val gson = Gson()
								val type = object : TypeToken<List<Daily>>() {}.type
								return gson.toJson(value, type)
				}

				@TypeConverter
				fun toCountryLangList(value : String) : List<Daily> {
								val gson = Gson()
								val type = object : TypeToken<List<Daily>>() {}.type
								return gson.fromJson(value, type)
				}
}
@ProvidedTypeConverter
class HourlyEntityConverter {

				@TypeConverter
				fun fromCountryLangList(value : List<Hourly>) : String {
								val gson = Gson()
								val type = object : TypeToken<List<Hourly>>() {}.type
								return gson.toJson(value, type)
				}

				@TypeConverter
				fun toCountryLangList(value : String) : List<Hourly> {
								val gson = Gson()
								val type = object : TypeToken<List<Hourly>>() {}.type
								return gson.fromJson(value, type)
				}
}

@ProvidedTypeConverter
class WeatherCurrentConverter {

				@TypeConverter
				fun fromCountryLangList(value : List<WeatherApiRes>) : String {
								val gson = Gson()
								val type = object : TypeToken<List<WeatherApiRes>>() {}.type
								return gson.toJson(value, type)
				}

				@TypeConverter
				fun toCountryLangList(value : String) : List<WeatherApiRes> {
								val gson = Gson()
								val type = object : TypeToken<List<WeatherApiRes>>() {}.type
								return gson.fromJson(value, type)
				}
}

@ProvidedTypeConverter
class CloudsEntityConverters {

				@TypeConverter
				fun appToString(app : CloudsEntity) : String = Gson().toJson(app)

				@TypeConverter
				fun stringToApp(string : String) : CloudsEntity =
								Gson().fromJson(string, CloudsEntity::class.java)

}
@ProvidedTypeConverter
class WeatherCurrentEntityConverters {

				@TypeConverter
				fun appToString(app : WeatherApiRes) : String = Gson().toJson(app)

				@TypeConverter
				fun stringToApp(string : String) : WeatherApiRes =
								Gson().fromJson(string, WeatherApiRes::class.java)

}
@ProvidedTypeConverter
class CoordEntityConverters {

				@TypeConverter
				fun appToString(app : CoordEntity) : String = Gson().toJson(app)

				@TypeConverter
				fun stringToApp(string : String) : CoordEntity =
								Gson().fromJson(string, CoordEntity::class.java)

}

@ProvidedTypeConverter
class MainEntityConverters {

				@TypeConverter
				fun appToString(app : MainEntity) : String = Gson().toJson(app)

				@TypeConverter
				fun stringToApp(string : String) : MainEntity = Gson().fromJson(string, MainEntity::class.java)

}

@ProvidedTypeConverter
class SysEntityConverters {

				@TypeConverter
				fun appToString(app : SysEntity) : String = Gson().toJson(app)

				@TypeConverter
				fun stringToApp(string : String) : SysEntity = Gson().fromJson(string, SysEntity::class.java)

}

@ProvidedTypeConverter
class WindEntityConverters {

				@TypeConverter
				fun appToString(app : WindEntity) : String = Gson().toJson(app)

				@TypeConverter
				fun stringToApp(string : String) : WindEntity = Gson().fromJson(string, WindEntity::class.java)

}