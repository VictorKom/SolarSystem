package com.example.solarsystem.ui.navigate

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.solarsystem.ui.screens.list.PlanetListScreen
import com.example.solarsystem.ui.screens.overview.PlanetOverviewScreen
import kotlinx.coroutines.flow.collect

@Composable
fun AppNavigation(
    navController: NavHostController,
    navigator: Navigator
) {
    LaunchedEffect(NAV_KEY) {
        navigator.screenFlow.collect { route ->
            if (route == BACK_ROUTE) {
                navController.popBackStack()
            } else {
                navController.navigate(route)
            }
        }
    }
    NavHost(
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
                navArgument(Screen.PlanetOverview.PLANET) {
                    type = PlanetNavType()
                }
            ),
            content = { PlanetOverviewScreen() }
        )
    }
}

private const val NAV_KEY = "NAV_KEY"
const val BACK_ROUTE = "BACK_ROUTE"
