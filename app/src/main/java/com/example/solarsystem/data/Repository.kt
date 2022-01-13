package com.example.solarsystem.data

import com.example.solarsystem.domain.model.Planet

interface Repository {
    suspend fun getPlanets(): List<Planet>
}
