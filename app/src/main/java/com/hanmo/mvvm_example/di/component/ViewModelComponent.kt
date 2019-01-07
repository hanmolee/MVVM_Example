package com.hanmo.mvvm_example.di.component

import com.hanmo.mvvm_example.di.module.NetworkModule
import com.hanmo.mvvm_example.ui.MarkerViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface ViewModelComponent {

    fun inject(markerViewModel: MarkerViewModel)

    @Component.Builder
    interface Builder {
        fun build() : ViewModelComponent
        fun networkModule(networkModule: NetworkModule) : Builder
    }
}