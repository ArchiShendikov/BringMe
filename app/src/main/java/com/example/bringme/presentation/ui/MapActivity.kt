package com.example.bringme.presentation.ui

import android.location.Location
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.bringme.R
import com.google.android.gms.location.*
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment

class MapActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var mMap: GoogleMap
    private lateinit var currentLocation: Location
    private lateinit var locationRequest: LocationRequest
    private lateinit var locationCallback: LocationCallback
    private lateinit var locationSettingsRequest: LocationSettingsRequest
    private lateinit var settingsClient: SettingsClient
    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map_google)
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)
        settingsClient = LocationServices.getSettingsClient(this)
        buildLocationRequest()
        buildLocationCallback()
        buildLocationSettingsRequest()
    }

    private fun buildLocationSettingsRequest() {
        var location = LocationSettingsRequest.Builder()
        location.addLocationRequest(locationRequest)
        locationSettingsRequest = location.build()
    }

    private fun buildLocationCallback() {
    }

    private fun buildLocationRequest() {
        locationRequest.interval = 10_000
        locationRequest.fastestInterval = 3_000
        locationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
    }

    override fun onMapReady(googleMap: GoogleMap) {

        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }
}
