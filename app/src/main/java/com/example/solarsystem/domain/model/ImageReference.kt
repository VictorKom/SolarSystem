package com.example.solarsystem.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ImageReference(val storageUrl: String) : Parcelable
