package com.hanmo.mvvm_example.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil.setContentView
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.hanmo.mvvm_example.LocationViewModel
import com.hanmo.mvvm_example.R
import com.hanmo.mvvm_example.base.BaseActivity
import com.hanmo.mvvm_example.databinding.ActivityMarkerBinding
import com.hanmo.mvvm_example.permission.PermissionViewModel


class MarkerActivity : BaseActivity<ActivityMarkerBinding>() {

    override val layoutResourceId: Int = R.layout.activity_marker

    private val permissionViewModel : PermissionViewModel by lazy { ViewModelProviders.of(this).get(PermissionViewModel::class.java) }
    private val locationViewModel : LocationViewModel by lazy { ViewModelProviders.of(this).get(LocationViewModel::class.java) }
    private val markerViewModel : MarkerViewModel by lazy { ViewModelProviders.of(this).get(MarkerViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_marker)
        viewDataBinding.markerViewModel = markerViewModel
        //viewDataBinding.viewModel = markerViewModel
        if (permissionViewModel.permissionToLocation) {
            Log.e("hanmolee", "${permissionViewModel.permissionToLocation}")
            locationViewModel.location.observe(this, Observer { location ->
                Log.e("hanmolee", "location is $location")
                //markerText.text = "latitiude : ${location?.latitude}   longitude ${location?.longitude}"
                markerViewModel.getMarkerToServer(location?.latitude, location?.longitude)
            })
        }

        /*markerViewModel.showResult.observe(this, Observer { result ->
            markerName.text = result
        })*/
    }

    override fun onResume() {
        super.onResume()

        locationViewModel.getLocation()

    }

}