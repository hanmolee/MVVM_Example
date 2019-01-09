package com.hanmo.mvvm_example.permission

import android.Manifest
import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.content.pm.PackageManager
import android.support.v4.content.ContextCompat

class PermissionViewModel(application: Application): AndroidViewModel(application) {

    var permissionToLocation = checkAccessLocationPermission(context = application)

    private fun checkAccessLocationPermission(context: Application) = ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED

}