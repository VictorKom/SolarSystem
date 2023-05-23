package com.example.solarsystem.ui.utils.coil

import coil.bitmap.BitmapPool
import coil.decode.DataSource
import coil.decode.Options
import coil.fetch.FetchResult
import coil.fetch.Fetcher
import coil.fetch.SourceResult
import coil.size.Size
import com.example.solarsystem.data.await
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import com.example.solarsystem.domain.model.ImageReference
import okio.buffer
import okio.source

class StorageReferenceFetcher : Fetcher<ImageReference> {

    override suspend fun fetch(
        pool: BitmapPool,
        data: ImageReference,
        size: Size,
        options: Options
    ): FetchResult {
        val taskSnapshot = Firebase.storage.getReferenceFromUrl(data.storageUrl).stream.await()
        return SourceResult(
            dataSource = DataSource.NETWORK,
            source = taskSnapshot.stream.source().buffer(),
            mimeType = null
        )
    }

    override fun key(data: ImageReference) = data.storageUrl

    override fun handles(data: ImageReference) = true
}
