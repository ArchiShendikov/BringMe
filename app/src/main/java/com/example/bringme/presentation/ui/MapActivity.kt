package com.example.bringme.presentation.ui

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.example.bringme.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class MapActivity : FragmentActivity(), OnMapReadyCallback {
    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map_google)
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val sydney: LatLng = LatLng(21.0, 57.0)
        mMap.addMarker(
            MarkerOptions()
                .position(sydney)
                .title("Sydney point")
        )
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }
}