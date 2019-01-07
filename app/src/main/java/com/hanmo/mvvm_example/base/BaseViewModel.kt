package com.hanmo.mvvm_example.base

import android.arch.lifecycle.ViewModel
import com.hanmo.mvvm_example.di.component.DaggerViewModelComponent
import com.hanmo.mvvm_example.di.component.ViewModelComponent
import com.hanmo.mvvm_example.di.module.NetworkModule
import com.hanmo.mvvm_example.ui.MarkerViewModel

abstract class BaseViewModel : ViewModel() {

    private val injector : ViewModelComponent = DaggerViewModelComponent
            .builder()
            .networkModule(NetworkModule)
            .build()

    init {
        inject()
    }

    private fun inject() {
        when(this) {
            is MarkerViewModel -> injector.inject(this)
        }
    }
}