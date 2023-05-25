package com.example.solarsystem.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Planet(
    val name: String,
    val imageReference: ImageReference,
    val description: String
) : Parcelable
