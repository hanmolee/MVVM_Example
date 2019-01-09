package com.hanmo.mvvm_example.base

import android.arch.lifecycle.ViewModel
import com.hanmo.mvvm_example.di.component.DaggerViewModelComponent
import com.hanmo.mvvm_example.di.component.ViewModelComponent
import com.hanmo.mvvm_example.di.module.NetworkModule
import com.hanmo.mvvm_example.ui.MarkerViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseViewModel : ViewModel() {

    private val compositeDisposable : CompositeDisposable = CompositeDisposable()

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

    fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}