package com.example.solarsystem.ui.navigate

import android.net.Uri
import com.example.solarsystem.domain.model.Planet
import com.google.gson.Gson

sealed class Screen {

    abstract val route: String

    object PlanetList : Screen() {

        private const val screeName = "planetList"

        override val route: String get() = screeName
    }

    object PlanetOverview : Screen() {

        const val PLANET = "planet"
        private const val screeName = "planetOverView"

        override val route: String get() = "$screeName/{$PLANET}"

        fun createRoute(planet: Planet) = "$screeName/${Uri.encode(Gson().toJson(planet))}"
    }
}
