package com.sasquer.forecast.navigation

import androidx.navigation.NavController
import com.sasquer.forecast.data.db.enteties.City

interface Navigation {
    fun bind(navController: NavController)
    fun unbind()

}