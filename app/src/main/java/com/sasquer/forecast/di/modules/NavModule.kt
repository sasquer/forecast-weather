package com.sasquer.forecast.di.modules

import com.sasquer.forecast.di.scopes.PerApplication
import com.sasquer.forecast.navigation.Navigation
import com.sasquer.forecast.navigation.NavigationImpl
import dagger.Binds
import dagger.Module

@Module
interface NavModule {
    @Binds
    @PerApplication
    fun bindNavigation(impl: NavigationImpl): Navigation
}