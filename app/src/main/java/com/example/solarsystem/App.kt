package com.example.solarsystem

import android.app.Application
import coil.Coil
import com.example.solarsystem.ui.utils.coil.StorageImageLoaderFactory
import dagger.Lazy
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

@HiltAndroidApp
class App : Application() {

    @Inject
    lateinit var imageLoaderFactory: Lazy<StorageImageLoaderFactory>

    override fun onCreate() {
        super.onCreate()
        CoroutineScope(Dispatchers.IO + SupervisorJob()).launch {
            Coil.setImageLoader(imageLoaderFactory.get())
        }
    }
}
