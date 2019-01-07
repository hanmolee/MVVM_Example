package com.hanmo.mvvm_example.ui

import com.hanmo.mvvm_example.base.BaseViewModel
import com.hanmo.mvvm_example.network.MarkerApi
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MarkerViewModel : BaseViewModel() {

    @Inject
    lateinit var markerApi : MarkerApi

    private val compositeDisposable : CompositeDisposable by lazy { CompositeDisposable() }

    init {
        loadCurrentMarker()
    }

    private fun loadCurrentMarker() {

    }

    fun getMarkerToServer() {
        //markerApi.getMarker()
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

}