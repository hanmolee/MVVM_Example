package com.hanmo.mvvm_example.ui

import com.hanmo.mvvm_example.base.BaseViewModel
import com.hanmo.mvvm_example.network.MarkerApi
import javax.inject.Inject

class MarkerViewModel : BaseViewModel() {

    @Inject
    lateinit var markerApi : MarkerApi

    init {
        loadCurrentMarker()
    }

    private fun loadCurrentMarker() {

    }

    fun getMarkerToServer() {
        //markerApi.getMarker()
    }

}