package com.hanmo.mvvm_example

import android.app.Application
import android.arch.lifecycle.LiveData
import android.location.Location
import com.hanmo.mvvm_example.base.BaseAndroidViewModel
import com.hanmo.mvvm_example.util.LocationLiveData


class LocationViewModel(application: Application) : BaseAndroidViewModel(application) {

    private val locationLiveData : LocationLiveData = LocationLiveData(application)
    val location : LiveData<Location> get() = locationLiveData

    fun getLocation() {
        locationLiveData.refreshLocation()
    }
}