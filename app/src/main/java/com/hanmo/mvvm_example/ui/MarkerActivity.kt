package com.hanmo.mvvm_example.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.location.Criteria
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.hanmo.mvvm_example.LocationViewModel
import com.hanmo.mvvm_example.R
import com.hanmo.mvvm_example.permission.PermissionViewModel
import kotlinx.android.synthetic.main.activity_marker.*

class MarkerActivity : AppCompatActivity() {

    private val permissionViewModel : PermissionViewModel by lazy { ViewModelProviders.of(this).get(PermissionViewModel::class.java) }
    private val locationViewModel : LocationViewModel by lazy { ViewModelProviders.of(this).get(LocationViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_marker)


        if (permissionViewModel.permissionToLocation) {
            Log.e("hanmolee", "${permissionViewModel.permissionToLocation}")
            locationViewModel.location.observe(this, Observer { location ->
                Log.e("hanmolee", "location is $location")
                markerText.text = "latitiude : ${location?.latitude}   longitude ${location?.longitude}"
            })

            
            locationViewModel.getLocation()
        }
    }

}