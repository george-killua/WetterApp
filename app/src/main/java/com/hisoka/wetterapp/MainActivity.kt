package com.hisoka.wetterapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.hisoka.wetterapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

				private lateinit var binding : ActivityMainBinding

				override fun onCreate(savedInstanceState : Bundle?) {
								super.onCreate(savedInstanceState)

								binding = ActivityMainBinding.inflate(layoutInflater)
								setContentView(binding.root)

								val navView : BottomNavigationView = binding.navView

								val navHostFragment =
												supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment
								val navController =
												navHostFragment.navController        // Passing each menu ID as a set of Ids because each
								// menu should be considered as top level destinations.
								val appBarConfiguration = AppBarConfiguration(
												setOf(
																R.id.forYouFragment, R.id.mapFragment, R.id.settingsFragment
												)
								)
								setupActionBarWithNavController(navController, appBarConfiguration)
								navView.setupWithNavController(navController)
								NavigationUI.setupActionBarWithNavController(this, navController)
				}

}