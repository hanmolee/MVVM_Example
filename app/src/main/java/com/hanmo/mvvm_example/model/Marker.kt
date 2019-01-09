package com.hanmo.mvvm_example.model

import com.google.gson.annotations.SerializedName

/**
 * longitude : 경도
 * latitude : 위도
 */

data class Marker(
        @SerializedName("result") val result: Result
)

data class Result(
        val locationName : String,
        val longitude : String,
        val latitude : String
)