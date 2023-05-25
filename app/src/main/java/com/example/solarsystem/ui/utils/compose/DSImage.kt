package com.example.solarsystem.ui.utils.compose

import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.with
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.BoxWithConstraintsScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import coil.imageLoader
import coil.request.ImageRequest
import com.example.solarsystem.R
import com.example.solarsystem.domain.model.ImageReference
import com.example.solarsystem.ui.theme.DS
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private sealed class DSImageState

private object Loading : DSImageState()

private data class Success(val painter: Painter) : DSImageState()

private object Error : DSImageState()

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun DSImage(
    modifier: Modifier = Modifier,
    imageReference: ImageReference?,
    contentScale: ContentScale = ContentScale.Crop,
) {
    BoxWithConstraints(modifier = modifier) {
        var imageState by remember(imageReference) { mutableStateOf<DSImageState>(Loading) }
        LaunchImageLoading(imageReference = imageReference, updateImageState = { imageState = it })
        AnimatedContent(
            modifier = Modifier.matchParentSize(),
            targetState = imageState,
            transitionSpec = { fadeIn() with fadeOut() }
        ) { targetState ->
            when (targetState) {
                is Success -> {
                    Image(
                        modifier = Modifier.fillMaxSize(),
                        painter = targetState.painter,
                        contentDescription = null,
                        contentScale = contentScale,
                    )
                }
                is Loading -> {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .skeleton(isLoading = true)
                    )
                }
                is Error -> ErrorImage()
            }
        }
    }
}

@Composable
private fun LaunchImageLoading(
    imageReference: ImageReference?,
    updateImageState: (DSImageState) -> Unit
) {
    val imageLoader = LocalContext.current.imageLoader
    val context = LocalContext.current
    val imageRequest = remember {
        ImageRequest.Builder(context)
            .data(imageReference)
            .build()
    }
    LaunchedEffect(imageReference) {
        if (imageReference == null) {
            updateImageState(Error)
            return@LaunchedEffect
        }
        launch(Dispatchers.Default) {
            val imagePainter = imageLoader.execute(imageRequest).drawable?.toPainter()
            updateImageState(if (imagePainter != null) Success(imagePainter) else Error)
        }
    }
}

private fun Drawable.toPainter() = when (this) {
    is BitmapDrawable -> BitmapPainter(bitmap.asImageBitmap())
    is ColorDrawable -> ColorPainter(Color(color))
    else -> null
}

@Composable
private fun BoxWithConstraintsScope.ErrorImage() {
    Image(
        modifier = Modifier.align(Alignment.Center),
        painter = painterResource(id = R.drawable.ic_disabled_image),
        contentDescription = null,
        colorFilter = ColorFilter.tint(DS.colors.textSecondary)
    )
}
