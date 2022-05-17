package com.example.week11ex2

import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.location.Location
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.*
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MainActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var mMap: GoogleMap
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var locationCallback: LocationCallback
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val permissions = arrayOf(
            android.Manifest.permission.ACCESS_COARSE_LOCATION,
            android.Manifest.permission.ACCESS_FINE_LOCATION)
        requirePermission(permissions, 999)
    }

    fun startProcess() {
        val mapFragment = supportFragmentManager.findFragmentById(R.id.mapView) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    fun requirePermission(permissions: Array<String>, requestCode: Int) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            permissionGranted(requestCode)
        } else {
            val isAllPermissionGranted = permissions.all {
                checkSelfPermission(it) == PackageManager.PERMISSION_GRANTED
            }
            if (isAllPermissionGranted) {
                permissionGranted(requestCode)
            } else {
                ActivityCompat.requestPermissions(this, permissions, requestCode)
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResult: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResult)
        if (grantResult.all{ it == PackageManager.PERMISSION_GRANTED}) {
            permissionGranted(requestCode)
        } else {
            permissionDenied(requestCode)
        }
    }

    fun permissionGranted(requestCode: Int) {
        startProcess()
    }

    fun permissionDenied(requestCode :Int) {
        Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show()
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        updateLocation()
    }

    @SuppressLint("MissingPermission")
    fun updateLocation() {
        val locationRequest = LocationRequest.create()
        locationRequest.run{
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY
            interval = 1000
        }

        locationCallback = object : LocationCallback() {
            override fun onLocationResult(locationResult : LocationResult?) {
                locationResult?.let{
                    for (location in it.locations) {
                        Log.d("MainActivity", "${location.latitude} , ${location.longitude}")
                        setLastLocation(location)
                    }
                }
            }
        }
        fusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, Looper.myLooper())
    }
    fun setLastLocation(lastLocation: Location) {
        val LATLNG = LatLng(lastLocation.latitude, lastLocation.longitude)
        val markerOptions = MarkerOptions().position(LATLNG).title("Marker in PNU");
        val cameraPosition = CameraPosition.Builder()
            .target(LATLNG)
            .zoom(15.0f)
            .build()
        mMap.clear()
        mMap.addMarker(markerOptions)
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))
    }
}
