package com.hanmo.mvvm_example.ui

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.hanmo.mvvm_example.base.BaseViewModel
import com.hanmo.mvvm_example.network.MarkerApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MarkerViewModel : BaseViewModel() {

    @Inject
    lateinit var markerApi : MarkerApi

    private val result = MutableLiveData<String>()
    val showResult: LiveData<String> get() = result

    init {
        loadCurrentMarker()
    }

    private fun loadCurrentMarker() {

    }

    fun getMarkerToServer(latitude: Double?, longitude: Double?) {

        markerApi.getMarker("", latitude.toString(), longitude.toString())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSuccess {  }
                .doOnError {  }
                .subscribe({ marker ->
                    Log.e("hanmolee", "result  ${marker.result.locationName}")
                    result.value = marker.result.locationName

                }, {error -> Log.e("hanmolee", "error is $error")})
    }

}