package com.sasquer.forecast.di.components

import com.sasquer.forecast.App
import com.sasquer.forecast.di.feature.FeatureMainHostModule
import com.sasquer.forecast.di.modules.NavModule
import com.sasquer.forecast.di.scopes.PerApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule

@PerApplication
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        NavModule::class,
        FeatureMainHostModule::class
    ]
)
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: App): AppComponent
    }

    fun inject(app: App)
}