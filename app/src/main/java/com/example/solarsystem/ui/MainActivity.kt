package com.example.solarsystem.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.solarsystem.ui.navigate.AppNavigation
import com.example.solarsystem.ui.navigate.Navigator
import com.example.solarsystem.ui.theme.SolarSystemTheme
import com.example.solarsystem.ui.theme.colors.SystemBarsColor
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SolarSystemApp(navigator)
        }
    }
}

@Composable
fun SolarSystemApp(navigator: Navigator) {
    SolarSystemTheme {
        AppNavigation(navController = rememberNavController(), navigator = navigator)
    }
}
