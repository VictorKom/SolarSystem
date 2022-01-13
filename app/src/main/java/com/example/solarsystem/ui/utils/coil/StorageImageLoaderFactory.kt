package com.example.solarsystem.ui.utils.coil

import android.content.Context
import coil.ImageLoader
import coil.ImageLoaderFactory
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class StorageImageLoaderFactory @Inject constructor(
    @ApplicationContext private val context: Context
) : ImageLoaderFactory {

    override fun newImageLoader(): ImageLoader {
        return ImageLoader.Builder(context)
            .componentRegistry { add(StorageReferenceFetcher()) }
            .crossfade(true)
            .build()
    }
}
