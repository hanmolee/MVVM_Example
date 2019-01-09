package com.hanmo.mvvm_example.ui.splash

import android.Manifest
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.hanmo.mvvm_example.R
import com.hanmo.mvvm_example.REQ_ACCESS_COARSE_LOCATION
import com.hanmo.mvvm_example.permission.PermissionViewModel
import com.hanmo.mvvm_example.ui.MarkerActivity
import com.hanmo.mvvm_example.util.NetworkUtil

class LoadingActivity : AppCompatActivity() {

    private val permissions : Array<String> by lazy { arrayOf(Manifest.permission.ACCESS_FINE_LOCATION) }
    private val permissionViewModel : PermissionViewModel by lazy { ViewModelProviders.of(this).get(PermissionViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)

        if (!permissionViewModel.permissionToLocation) {
            ActivityCompat.requestPermissions(this, permissions, REQ_ACCESS_COARSE_LOCATION)
        } else {
            Handler().postDelayed({
                startActivity(Intent(this, MarkerActivity::class.java))
                finish()
            }, 1000)
        }


        //네트워크 관련 된 사항 보여주기 위해
        if (NetworkUtil.isNetworkAvailable(this)) {

        } else {

        }


    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when(requestCode) {
            REQ_ACCESS_COARSE_LOCATION -> {
                permissionViewModel.permissionToLocation = grantResults[0] == PackageManager.PERMISSION_GRANTED
            }
            else -> {
                super.onRequestPermissionsResult(requestCode, permissions, grantResults)
            }
        }

        startActivity(Intent(this, MarkerActivity::class.java))
        finish()
    }



    override fun onBackPressed() {}


}