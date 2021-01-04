package com.sasquer.forecast.di.feature

import com.sasquer.forecast.MainActivity
import com.sasquer.forecast.di.scopes.PerActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface FeatureMainHostModule {

    @PerActivity
    @ContributesAndroidInjector(
        modules = [
            FeatureMainModule::class
        ]
    )
    fun mainActivityInjector(): MainActivity

}