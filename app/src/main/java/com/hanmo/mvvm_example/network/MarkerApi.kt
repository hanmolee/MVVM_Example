package com.hanmo.mvvm_example.network

import com.hanmo.mvvm_example.model.Marker
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MarkerApi {

    @GET("")
    fun getMarker(@Query("locationName") locationName: String?, @Query("latitude") latitude : String?, @Query("longitude") longitude : String?) : Single<Marker>

}