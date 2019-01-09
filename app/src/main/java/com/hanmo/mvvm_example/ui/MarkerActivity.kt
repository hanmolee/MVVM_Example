package com.hanmo.mvvm_example.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.hanmo.mvvm_example.R
import com.hanmo.mvvm_example.permission.PermissionViewModel
import com.hanmo.mvvm_example.util.LocationLiveData
import kotlinx.android.synthetic.main.activity_marker.*

class MarkerActivity : AppCompatActivity() {

    private val permissionViewModel : PermissionViewModel by lazy { ViewModelProviders.of(this).get(PermissionViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_marker)


        if (permissionViewModel.permissionToLocation) {
            val location = LocationLiveData(this).observe(this, Observer {
                markerText.text = "longitude ${it?.longitude}  latitude ${it?.latitude}"
            })
        }
    }

}