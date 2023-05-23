package com.example.solarsystem.ui.screens.list

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.example.solarsystem.R
import com.example.solarsystem.domain.model.Planet
import com.example.solarsystem.domain.util.Lce
import com.example.solarsystem.ui.theme.DS
import com.example.solarsystem.ui.theme.colors.SystemBarsColor
import com.example.solarsystem.ui.utils.compose.Skeleton
import com.example.solarsystem.ui.utils.compose.SkeletonShape
import kotlin.math.absoluteValue

@Composable
fun PlanetListScreen() {
    val viewModel: PlanetListViewModel = hiltViewModel()
    SystemBarsColor(DS.colors.backgroundSecondary)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DS.colors.backgroundSecondary)
    ) {
        Text(
            modifier = Modifier.padding(vertical = 20.dp, horizontal = 32.dp),
            text = stringResource(R.string.app_name),
            style = DS.typography.h3
        )
        when (val state = viewModel.planetList.collectAsState().value) {
            is Lce.Loading -> Loading()
            is Lce.Error -> Text(text = stringResource(R.string.error_message))
            is Lce.Success -> Content(
                planets = state.data ?: listOf(),
                navigateToPlanetOverview = viewModel::navigateToPlanetOverview
            )
        }
    }
}

@Composable
private fun Loading() {
    PlanetPager(size = 3) { LoadingPlanetItem() }
}

@Composable
private fun Content(planets: List<Planet>, navigateToPlanetOverview: (Planet) -> Unit) {
    PlanetPager(size = planets.size) { page ->
        PlanetItem(planet = planets[page], navigateToPlanetOverview = navigateToPlanetOverview)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun PlanetPager(size: Int, item: @Composable (Int) -> Unit) {
    HorizontalPager(
        pageCount = size,
        pageSpacing = (-20).dp,
        contentPadding = PaddingValues(horizontal = 32.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp, bottom = 100.dp)
    ) { page ->
        Card(
            modifier = Modifier
                .graphicsLayer {
                    // Calculate the absolute offset for the current page from the
                    // scroll position. We use the absolute value which allows us to mirror
                    // any effects for both directions
//                    val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue
//                    // We animate the scaleX + scaleY, between 85% and 100%
//                    lerp(
//                        start = 0.85f,
//                        stop = 1f,
//                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
//                    ).also { scale ->
//                        scaleX = scale
//                        scaleY = scale
//                    }
//                    // We animate the alpha, between 50% and 100%
//                    alpha = lerp(
//                        start = 0.5f,
//                        stop = 1f,
//                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
//                    )
                }
                .fillMaxSize()
                .padding(top = 4.dp, start = 8.dp, end = 8.dp, bottom = 16.dp),
            shape = RoundedCornerShape(16.dp),
            elevation = 8.dp
        ) {
            item(page)
        }
    }
}

@Composable
private fun PlanetItem(planet: Planet, navigateToPlanetOverview: (Planet) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable { navigateToPlanetOverview(planet) }
    ) {
        Icon(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(16.dp),
            painter = DS.icons.help.toPainter(),
            contentDescription = null,
            tint = DS.colors.primary
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 34.dp),
            text = planet.name,
            style = DS.typography.h1,
            textAlign = TextAlign.Center
        )
        Image(
            modifier = Modifier
                .padding(16.dp)
                .size(256.dp)
                .align(Alignment.Center),
            painter = rememberImagePainter(data = planet.coverUrl),
            contentDescription = null,
        )
    }
}

@Composable
private fun LoadingPlanetItem() {
    Box(modifier = Modifier.fillMaxSize()) {
        Icon(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(16.dp),
            painter = DS.icons.help.toPainter(),
            contentDescription = null,
            tint = DS.colors.primary
        )
        Skeleton(
            modifier = Modifier
                .width(180.dp)
                .align(Alignment.TopCenter)
                .padding(top = 34.dp),
            shape = SkeletonShape.Text(textStyle = DS.typography.h1)
        )
        Skeleton(
            modifier = Modifier
                .padding(16.dp)
                .size(256.dp)
                .align(Alignment.Center),
            shape = SkeletonShape.Rectangle(24)
        )
    }
}
