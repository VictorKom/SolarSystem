package com.example.solarsystem.ui.navigate

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject

class NavigatorImpl @Inject constructor() : Navigator {

    private val _screenFlow = Channel<String>(capacity = 10)
    override val screenFlow = _screenFlow.receiveAsFlow()

    override fun navigateTo(route: String) {
        _screenFlow.trySend(route)
    }

    override fun back() {
        _screenFlow.trySend(BACK_ROUTE)
    }
}

interface Navigator {

    val screenFlow: Flow<String>

    fun navigateTo(route: String)

    fun back()
}
