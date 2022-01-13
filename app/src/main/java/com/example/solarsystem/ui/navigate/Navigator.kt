package com.example.solarsystem.ui.navigate

import javax.inject.Inject
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow

class NavigatorImpl @Inject constructor() : Navigator {

    private val _screenFlow = MutableSharedFlow<String>(extraBufferCapacity = 1)
    override val screenFlow = _screenFlow.asSharedFlow()

    override fun navigateTo(route: String) {
        _screenFlow.tryEmit(route)
    }

    override fun back() {
        _screenFlow.tryEmit(BACK_ROUTE)
    }
}

interface Navigator {

    val screenFlow: SharedFlow<String>

    fun navigateTo(route: String)

    fun back()
}
