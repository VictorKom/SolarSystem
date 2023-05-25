package com.example.solarsystem.ui.screens.overview

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.solarsystem.ui.theme.DS
import com.example.solarsystem.ui.utils.compose.DSImage
import com.example.solarsystem.ui.utils.compose.DSTopAppBar

@Composable
fun PlanetOverviewScreen() {
    val viewModel = hiltViewModel<PlanetOverviewViewModel>()
    val planet = viewModel.planet ?: return
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        DSTopAppBar(
            title = planet.name,
            backgroundColor = DS.colors.backgroundSecondary,
            back = viewModel::back
        )
        Spacer(Modifier.height(20.dp))
        DSImage(
            modifier = Modifier
                .size(256.dp)
                .clip(CircleShape)
                .align(Alignment.CenterHorizontally),
            imageReference = planet.imageReference
        )
        Text(
            modifier = Modifier.padding(16.dp),
            text = planet.description,
            style = DS.typography.body1
        )
    }
}
