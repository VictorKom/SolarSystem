package com.example.solarsystem.data.dto

import com.example.solarsystem.domain.model.Planet
import com.example.solarsystem.domain.model.ImageReference

data class PlanetDto(
    val name: String? = null,
    val cover: String? = null,
    val description: String? = null
) {
    companion object {
        fun convert(planetDto: PlanetDto): Planet {
            return Planet(
                name = planetDto.name ?: "",
                imageReference = ImageReference(planetDto.cover ?: ""),
                description = planetDto.description ?: ""
            )
        }
    }
}
