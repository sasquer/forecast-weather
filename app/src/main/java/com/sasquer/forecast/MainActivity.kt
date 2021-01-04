package com.sasquer.forecast

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.sasquer.forecast.navigation.HasNavController
import com.sasquer.forecast.utils.setupToolbar
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasAndroidInjector, HasNavController {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    private val destinationChangeListener =
        NavController.OnDestinationChangedListener { controller, destination, arguments ->
            invalidateOptionsMenu()
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        setupToolbar(toolbar)
        toolbar.setupWithNavController(navController)
    }

    override fun onStart() {
        super.onStart()
        navController.addOnDestinationChangedListener(destinationChangeListener)
    }

    override fun onStop() {
        super.onStop()
        navController.removeOnDestinationChangedListener(destinationChangeListener)
    }

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    override val navController: NavController by lazy(LazyThreadSafetyMode.NONE) {
        findNavController(R.id.nav_host_fragment)
    }
}