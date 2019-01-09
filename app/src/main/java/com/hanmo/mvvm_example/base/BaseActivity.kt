package com.hanmo.mvvm_example.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity<T: ViewDataBinding>:  AppCompatActivity(){

    lateinit var viewDataBinding: T

    abstract val layoutResourceId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewDataBinding = DataBindingUtil.setContentView(this, layoutResourceId)
    }
}