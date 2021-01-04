package com.sasquer.forecast.di.feature

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sasquer.forecast.di.scopes.PerFragment
import com.sasquer.forecast.ui.main.MainFragment
import com.sasquer.forecast.ui.main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import javax.inject.Inject

@Module
interface FeatureMainModule {
    @PerFragment
    @ContributesAndroidInjector(modules = [MainFragmentModule::class])
    fun contributeMainFragment(): MainFragment
}

@Module
interface MainFragmentModule {
    @Binds
    @PerFragment
    fun MainViewModelFactory.provideViewModelFactory(): ViewModelProvider.Factory
}

class MainViewModelFactory @Inject constructor() : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return MainViewModel() as T
    }
}