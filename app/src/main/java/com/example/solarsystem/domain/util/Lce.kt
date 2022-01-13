package com.example.solarsystem.domain.util

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

sealed class Lce<out T> {
    open val data: T? = null

    data class Success<T>(override var data: T?) : Lce<T>()
    object Loading : Lce<Nothing>()
    data class Error(val message: String?) : Lce<Nothing>()
}

inline fun <T> lce(crossinline block: suspend () -> T): Flow<Lce<T>> = flow {
    emit(Lce.Loading)
    emit(
        Lce.Success(
            withContext(Dispatchers.IO) {
                block()
            }
        )
    )
}.catch { emit(Lce.Error(it.message)) }
