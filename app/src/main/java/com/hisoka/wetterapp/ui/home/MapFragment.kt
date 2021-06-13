package com.hisoka.wetterapp.ui.home

import android.Manifest
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.*
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.preference.PreferenceManager
import com.hisoka.wetterapp.R
import com.hisoka.wetterapp.databinding.FragmentMapBinding
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.views.*
import org.osmdroid.views.overlay.mylocation.*
import java.util.*


class MapFragment : Fragment() {
				private val REQUEST_PERMISSIONS_REQUEST_CODE = 1
				private lateinit var mapViewModel : MapViewModel
				private var _binding : FragmentMapBinding? = null

				// This property is only valid between onCreateView and
				// onDestroyView.
				private val binding get() = _binding!!
				private lateinit var map : MapView
				override fun onCreateView(
												inflater : LayoutInflater,
												container : ViewGroup?,
												savedInstanceState : Bundle?
				) : View {
								mapViewModel =
												ViewModelProvider(this).get(MapViewModel::class.java)

								_binding = FragmentMapBinding.inflate(inflater, container, false)

								//handle permissions first, before map is created. not depicted here

								//load/initialize the osmdroid configuration, this can be done

								Configuration.getInstance().load(
												context?.applicationContext, PreferenceManager
																.getDefaultSharedPreferences(context)
								);
								//setting this before the layout is inflated is a good idea
								//it 'should' ensure that the map has a writable location for the map cache, even without permissions
								//if no tiles are displayed, you can try overriding the cache path using Configuration.getInstance().setCachePath
								//see also StorageUtils
								//note, the load method also sets the HTTP User Agent to your application's package name, abusing osm's tile servers will get you banned based on this string

								map = binding.map
								map.setTileSource(TileSourceFactory.MAPNIK);
								map.zoomController.setVisibility(CustomZoomButtonsController.Visibility.SHOW_AND_FADEOUT)
								map.setMultiTouchControls(true)
							val myLocationOverlay = MyLocationNewOverlay(GpsMyLocationProvider(context), map)
								myLocationOverlay.enableMyLocation()
								val icon = BitmapFactory.decodeResource(
												requireContext().resources,
												R.drawable.ic_home_black_24dp
								)
								myLocationOverlay.setPersonIcon(icon)
								map.overlays.add(myLocationOverlay)

								val mapController = map.controller
								mapController.setZoom(18.0)
		/*						val startPoint = GeoPoint(46.8023145, 13.4573484)

								mapController.setCenter(startPoint)*/
								mapController.setCenter(myLocationOverlay.myLocation)
								requestPermissionsIfNecessary( arrayOf<String>(
												// Wird später auskommentiert, da GNSS noch nicht benötigt wird
												// Manifest.permission.ACCESS_FINE_LOCATION,
												// WRITE_EXTERNAL_STORAGE is required in order to show the map
												Manifest.permission.WRITE_EXTERNAL_STORAGE
												, Manifest.permission.ACCESS_FINE_LOCATION
												, Manifest.permission.ACCESS_COARSE_LOCATION
												));
								return binding.root
				}
				private fun checkAndRequestPermissions() : Boolean {
								val camera = ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.CAMERA)
								val storage =
												ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE)
								val loc =
												ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_COARSE_LOCATION)
								val loc2 = ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION)
								val listPermissionsNeeded : MutableList<String> = ArrayList()
								if (camera != PackageManager.PERMISSION_GRANTED) {
												listPermissionsNeeded.add(Manifest.permission.CAMERA)
								}
								if (storage != PackageManager.PERMISSION_GRANTED) {
												listPermissionsNeeded.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
								}
								if (loc2 != PackageManager.PERMISSION_GRANTED) {
												listPermissionsNeeded.add(Manifest.permission.ACCESS_FINE_LOCATION)
								}
								if (loc != PackageManager.PERMISSION_GRANTED) {
												listPermissionsNeeded.add(Manifest.permission.ACCESS_COARSE_LOCATION)
								}
								if (listPermissionsNeeded.isNotEmpty()) {
												ActivityCompat.requestPermissions(
																requireActivity(),
																listPermissionsNeeded.toTypedArray(),
																REQUEST_PERMISSIONS_REQUEST_CODE
												)
												return false
								}
								return true
				}
				override fun onResume() {
								super.onResume();
								//this will refresh the osmdroid configuration on resuming.
								//if you make changes to the configuration, use
								//SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
								//Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this));
								map.onResume(); //needed for compass, my location overlays, v6.0.0 and up
				}

				override fun onPause() {
								super.onPause();
								//this will refresh the osmdroid configuration on resuming.
								//if you make changes to the configuration, use
								//SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
								//Configuration.getInstance().save(this, prefs);
								map.onPause();  //needed for compass, my location overlays, v6.0.0 and up
				}

				/*		mapViewModel.text.observe(viewLifecycleOwner, Observer {
								textView.text = it
				})*/

				override fun onRequestPermissionsResult(requestCode : Int,
				                                        permissions : Array<String?>,
				                                        grantResults : IntArray) {
								val permissionsToRequest : ArrayList<String?> = ArrayList()
								for (i in grantResults.indices) {
												permissionsToRequest.add(permissions[i])
								}
								if (permissionsToRequest.size > 0) {
												ActivityCompat.requestPermissions(
																requireActivity(),
																permissionsToRequest.toArray(arrayOfNulls(0)),
																REQUEST_PERMISSIONS_REQUEST_CODE
												)
								}
				}

				private fun requestPermissionsIfNecessary(permissions : Array<String>) {
								val permissionsToRequest : ArrayList<String> = ArrayList()
								for (permission in permissions) {
												if (ContextCompat.checkSelfPermission(requireContext(), permission)
																!= PackageManager.PERMISSION_GRANTED) {
																// Permission is not granted
																permissionsToRequest.add(permission)
												}
								}
								if (permissionsToRequest.size > 0) {
												ActivityCompat.requestPermissions(
																requireActivity(),
																permissionsToRequest.toArray(arrayOfNulls(0)),
																REQUEST_PERMISSIONS_REQUEST_CODE
												)
								}
				}

				override fun onDestroyView() {
								super.onDestroyView()
								_binding = null
				}
}