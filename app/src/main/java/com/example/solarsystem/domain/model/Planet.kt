package com.example.solarsystem.domain.model

import android.os.Parcelable
import com.physics.domain.model.ImageReference
import kotlinx.parcelize.Parcelize

@Parcelize
data class Planet(
    val name: String,
    val coverUrl: ImageReference,
    val description: String
) : Parcelable
