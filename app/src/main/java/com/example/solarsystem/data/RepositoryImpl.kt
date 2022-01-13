package com.example.solarsystem.data

import com.example.solarsystem.data.dto.PlanetDto
import com.example.solarsystem.domain.model.Planet
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import javax.inject.Inject

class RepositoryImpl @Inject constructor() : Repository {

    private val database = Firebase.firestore

    override suspend fun getPlanets(): List<Planet> {
        return database
            .collection(PLANET_COLLECTION)
            .orderBy(INDEX_FIELD)
            .get()
            .await()
            .mapNotNull { PlanetDto.convert(it.toObject(PlanetDto::class.java)) }
    }
}

private const val PLANET_COLLECTION = "planets"
private const val INDEX_FIELD = "index"
