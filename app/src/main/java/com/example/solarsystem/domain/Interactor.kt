package com.example.solarsystem.domain

import com.example.solarsystem.domain.model.Planet
import com.example.solarsystem.domain.util.Lce
import kotlinx.coroutines.flow.Flow

interface Interactor {
    fun getPlanets(): Flow<Lce<List<Planet>>>
}
