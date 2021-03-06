package com.sasquer.forecast

import android.app.Application
import com.sasquer.forecast.di.components.DaggerAppComponent
import com.sasquer.forecast.utils.NavigationLifecycleCallback
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class App : Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var navigationLifecycleCallback: NavigationLifecycleCallback

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent.factory()
            .create(this)
            .inject(this)

        registerNavigationCallback()
    }

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    private fun registerNavigationCallback() {
        registerActivityLifecycleCallbacks(navigationLifecycleCallback)
    }

}