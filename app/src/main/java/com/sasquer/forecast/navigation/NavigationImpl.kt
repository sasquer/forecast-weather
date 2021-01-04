package com.sasquer.forecast.navigation

import androidx.navigation.NavController
import com.sasquer.forecast.data.db.enteties.City
import javax.inject.Inject

class NavigationImpl @Inject constructor() : Navigation {
    private var navController: NavController? = null

    override fun bind(navController: NavController) {
        this.navController = navController
    }

    override fun unbind() {
        navController = null
    }
}