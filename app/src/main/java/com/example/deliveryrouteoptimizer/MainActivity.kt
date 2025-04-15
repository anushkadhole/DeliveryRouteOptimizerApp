package com.example.deliveryrouteoptimizer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        val database = FirebaseDatabase.getInstance()
        val routeRef = database.getReference("routes")
        routeRef.setValue("Sample Route Updated!")
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val startPoint = LatLng(37.7749, -122.4194)
        mMap.addMarker(MarkerOptions().position(startPoint).title("Start Point"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(startPoint, 12f))
    }
}
