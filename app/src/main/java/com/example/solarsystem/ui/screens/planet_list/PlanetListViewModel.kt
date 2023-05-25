package com.example.solarsystem.ui.screens.planet_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.solarsystem.domain.Interactor
import com.example.solarsystem.domain.util.Lce
import com.example.solarsystem.domain.model.Planet
import com.example.solarsystem.ui.navigation.Navigator
import com.example.solarsystem.ui.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class PlanetListViewModel @Inject constructor(
    private val interactor: Interactor,
    navigator: Navigator
) : ViewModel(), Navigator by navigator {

    private val _planetList: MutableStateFlow<Lce<List<Planet>>> = MutableStateFlow(Lce.Loading)
    val planetList = _planetList.asStateFlow()

    init {
        viewModelScope.launch {
            interactor.getPlanets().collect {
                _planetList.value = it
            }
        }
    }

    fun navigateToPlanetOverview(planet: Planet) {
        navigateTo(Screen.PlanetOverview.createRoute(planet))
    }
}
