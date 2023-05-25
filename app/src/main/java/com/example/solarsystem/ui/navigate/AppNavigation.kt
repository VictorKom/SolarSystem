package com.example.solarsystem.ui.navigate

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.solarsystem.ui.screens.list.PlanetListScreen
import com.example.solarsystem.ui.screens.overview.PlanetOverviewScreen
import com.example.solarsystem.ui.theme.DS
import com.example.solarsystem.ui.theme.colors.SystemBarsColor

@Composable
fun AppNavigation(
    navController: NavHostController,
    navigator: Navigator
) {
    LaunchedEffect(Unit) {
        navigator.screenFlow.collect { route ->
            if (route == BACK_ROUTE) {
                navController.popBackStack()
            } else {
                navController.navigate(route)
            }
        }
    }
    SystemBarsColor(DS.colors.backgroundSecondary)
    NavHost(
        modifier = Modifier
            .fillMaxSize()
            .background(DS.colors.backgroundSecondary),
        navController = navController,
        startDestination = Screen.PlanetList.route
    ) {
        composable(
            route = Screen.PlanetList.route,
            content = { PlanetListScreen() }
        )
        composable(
            route = Screen.PlanetOverview.route,
            arguments = listOf(
                navArgument(Screen.PlanetOverview.PLANET_ARG) {
                    type = PlanetNavType()
                }
            ),
            content = { PlanetOverviewScreen() }
        )
    }
}

const val BACK_ROUTE = "BACK_ROUTE"
