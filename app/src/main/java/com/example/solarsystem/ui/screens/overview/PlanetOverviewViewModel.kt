package com.example.solarsystem.ui.screens.overview

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.solarsystem.domain.model.Planet
import com.example.solarsystem.ui.navigate.Navigator
import com.example.solarsystem.ui.navigate.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PlanetOverviewViewModel @Inject constructor(
    stateHandle: SavedStateHandle,
    navigator: Navigator
) : ViewModel(), Navigator by navigator {

    val planet = stateHandle.get<Planet>(Screen.PlanetOverview.PLANET)
}
