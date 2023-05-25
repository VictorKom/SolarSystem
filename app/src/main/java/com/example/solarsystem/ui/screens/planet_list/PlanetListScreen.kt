package com.example.solarsystem.ui.screens.planet_list

import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.solarsystem.R
import com.example.solarsystem.domain.model.ImageReference
import com.example.solarsystem.domain.model.Planet
import com.example.solarsystem.domain.util.Lce
import com.example.solarsystem.ui.theme.DS
import com.example.solarsystem.ui.utils.compose.DSImage
import com.example.solarsystem.ui.utils.compose.LocalIsLoading
import com.example.solarsystem.ui.utils.compose.skeleton
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlin.math.absoluteValue
import kotlin.math.min

@Composable
fun PlanetListScreen() {
    val viewModel: PlanetListViewModel = hiltViewModel()
    PlanetListContent(
        viewStateFlow = viewModel.planetList,
        navigateToPlanetOverview = viewModel::navigateToPlanetOverview
    )
}

@Composable
fun PlanetListContent(
    viewStateFlow: StateFlow<Lce<List<Planet>>>,
    navigateToPlanetOverview: (Planet) -> Unit
) {
    val viewState = viewStateFlow.collectAsState().value
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            modifier = Modifier.padding(vertical = 20.dp, horizontal = 32.dp),
            text = stringResource(R.string.app_name),
            style = DS.typography.h3
        )
        when (viewState) {
            is Lce.Loading -> Loading()
            is Lce.Error -> Text(
                modifier = Modifier.weight(1f),
                text = stringResource(R.string.error_message),
                style = DS.typography.body1,
                color = DS.palette.white,
                textAlign = TextAlign.Center
            )

            is Lce.Success -> PlanetPager(
                planets = viewState.data ?: listOf(),
                navigateToPlanetOverview = navigateToPlanetOverview
            )
        }
    }
}

@Composable
private fun Loading() {
    CompositionLocalProvider(LocalIsLoading provides true) {
        PlanetPager(
            planets = planetListPreview,
            navigateToPlanetOverview = {}
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun PlanetPager(planets: List<Planet>, navigateToPlanetOverview: (Planet) -> Unit) {
    val pagerState = rememberPagerState()
    val scale by remember {
        derivedStateOf {
            1f - (pagerState.currentPageOffsetFraction.absoluteValue) * .3f
        }
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        val offsetFromStart = pagerState.offsetForPage(0).absoluteValue
        Box(
            modifier = Modifier
                .aspectRatio(1f)
                .offset { IntOffset(0, 150.dp.roundToPx()) }
                .scale(scaleX = .6f, scaleY = .24f)
                .scale(scale)
                .rotate(offsetFromStart * 90f)
                .blur(
                    radius = 110.dp,
                    edgeTreatment = BlurredEdgeTreatment.Unbounded,
                )
                .background(Color.Black.copy(alpha = .5f))
        )

        HorizontalPager(
            state = pagerState,
            pageCount = planets.size,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 20.dp, bottom = 100.dp)
        ) { page ->
            Box(
                modifier = Modifier
                    .graphicsLayer {
                        val pageOffset = pagerState.offsetForPage(page)
                        val offScreenRight = pageOffset < 0f
                        val deg = 105f
                        val interpolated = FastOutLinearInEasing.transform(pageOffset.absoluteValue)
                        rotationY = min(interpolated * if (offScreenRight) deg else -deg, 90f)

                        transformOrigin = TransformOrigin(
                            pivotFractionX = if (offScreenRight) 0f else 1f,
                            pivotFractionY = .5f
                        )
                    }
                    .drawWithContent {
                        val pageOffset = pagerState.offsetForPage(page)
                        this.drawContent()
                        drawRect(Color.Black.copy((pageOffset.absoluteValue * .7f)))
                    }
                    .fillMaxSize()
                    .background(DS.colors.background),
            ) {
                PlanetItem(
                    planet = planets[page],
                    navigateToPlanetOverview = navigateToPlanetOverview
                )
            }
        }
    }
}

@Composable
private fun PlanetItem(planet: Planet, navigateToPlanetOverview: (Planet) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = { navigateToPlanetOverview(planet) }
            )
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.space),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Text(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 34.dp)
                .skeleton(shape = RoundedCornerShape(10.dp)),
            text = planet.name,
            style = DS.typography.h1,
            color = DS.palette.white,
            textAlign = TextAlign.Center
        )
        DSImage(
            modifier = Modifier
                .size(256.dp)
                .align(Alignment.Center)
                .clip(CircleShape)
                .skeleton(),
            imageReference = planet.imageReference
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
fun PagerState.offsetForPage(page: Int) = (currentPage - page) + currentPageOffsetFraction

private val planetListPreview = listOf(
    Planet(name = "Mercury", imageReference = ImageReference(""), description = ""),
    Planet(name = "Venus", imageReference = ImageReference(""), description = ""),
    Planet(name = "Earth", imageReference = ImageReference(""), description = ""),
)

@Preview
@Composable
fun PlanetListContentPreview() {
    PlanetListContent(
        viewStateFlow = MutableStateFlow(Lce.Success(planetListPreview)),
        navigateToPlanetOverview = {}
    )
}