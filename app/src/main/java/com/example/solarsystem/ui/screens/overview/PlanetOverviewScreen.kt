package com.example.solarsystem.ui.screens.overview

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.example.solarsystem.ui.theme.DS
import com.example.solarsystem.ui.theme.colors.SystemBarsColor
import com.example.solarsystem.ui.utils.compose.DSTopAppBar

@Composable
fun PlanetOverviewScreen() {
    SystemBarsColor(DS.colors.background)
    val viewModel = hiltViewModel<PlanetOverviewViewModel>()
    val planet = viewModel.planet ?: return
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(DS.colors.background)
    ) {
        DSTopAppBar(planet.name, back = viewModel::back)
        Spacer(Modifier.height(20.dp))
        Image(
            modifier = Modifier
                .size(256.dp)
                .align(Alignment.CenterHorizontally),
            painter = rememberImagePainter(data = planet.coverUrl),
            contentDescription = null,
        )
        Text(
            modifier = Modifier.padding(16.dp),
            text = planet.description,
            style = DS.typography.body1
        )
    }
}
