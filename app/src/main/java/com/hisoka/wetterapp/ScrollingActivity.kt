package com.hisoka.wetterapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.hisoka.wetterapp.data.one_call_req.WeatherResponse
import com.hisoka.wetterapp.databinding.ActivityScrollingBinding
import com.hisoka.wetterapp.networking.WeatherApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ScrollingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScrollingBinding
    private var baseUrl = "http://api.openweathermap.org/"
    private var appId = "e430a5f0d264a55c180ce94eed4317bc"
    private var lat = "35"
    private var lon = "139"

    private var weatherData: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityScrollingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        weatherData = findViewById(R.id.tv_result)
        setSupportActionBar(findViewById(R.id.toolbar))
        binding.toolbarLayout.title = title
        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
            getCurrentData()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_scrolling, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun getCurrentData() {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(WeatherApiService::class.java)
        val call = service.getCurrentWeatherData(lat, lon, appId)
        call.enqueue(object : Callback<WeatherResponse> {
            override fun onResponse(
                call: Call<WeatherResponse>,
                response: Response<WeatherResponse>
            ) {
                if (response.code() == 200) {
                    val weatherDataResponse: WeatherResponse = response.body()!!
                    val stringBuilder: String = "Country: " +
                            weatherDataResponse.sys.country +
                            "\n" +
                            "Temperature: " +
                            weatherDataResponse.main.temp +
                            "\n" +
                            "Temperature(Min): " +
                            weatherDataResponse.main.tempMin +
                            "\n" +
                            "Temperature(Max): " +
                            weatherDataResponse.main.tempMax +
                            "\n" +
                            "Humidity: " +
                            weatherDataResponse.main.humidity +
                            "\n" +
                            "Pressure: " +
                            weatherDataResponse.main.pressure

                    weatherData?.text = stringBuilder
                }
            }

            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                weatherData?.text = t.message
            }

        })
    }
}