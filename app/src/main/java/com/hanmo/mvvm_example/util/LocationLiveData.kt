package com.hanmo.mvvm_example.util

import android.annotation.SuppressLint
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.util.Log

class LocationLiveData(context: Context) : LiveData<Location>(), LocationListener {

    private val locationManager: LocationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager

    @SuppressLint("MissingPermission")
    override fun onInactive() {
        Log.e("hanmolee", "Inactive")
        locationManager.removeUpdates(this)
    }

    @SuppressLint("MissingPermission")
    fun refreshLocation() {
        Log.e("hanmolee", "refreshLocation")
        locationManager.requestSingleUpdate(LocationManager.GPS_PROVIDER, this, null )
        val lastLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
        Log.e("hanmolee", "refreshLocation Last longitude : ${lastLocation.longitude}  latitude : ${lastLocation.latitude}")
        value = lastLocation
    }

    override fun onLocationChanged(location: Location?) {
        Log.e("hanmolee", "onLocationChange $location")
        value = location
    }

    override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {

    }

    override fun onProviderEnabled(provider: String?) {

    }

    override fun onProviderDisabled(provider: String?) {

    }

}