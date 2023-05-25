package com.example.solarsystem.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.compose.rememberNavController
import com.example.solarsystem.ui.navigation.AppNavigation
import com.example.solarsystem.ui.navigation.Navigator
import com.example.solarsystem.ui.theme.SolarSystemTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SolarSystemTheme {
                AppNavigation(
                    navController = rememberNavController(),
                    navigator = navigator
                )
            }
        }
    }
}
