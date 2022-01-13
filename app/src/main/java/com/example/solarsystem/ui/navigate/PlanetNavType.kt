package com.example.solarsystem.ui.navigate

import android.os.Bundle
import androidx.navigation.NavType
import com.example.solarsystem.domain.model.Planet
import com.google.gson.Gson

class PlanetNavType : NavType<Planet>(isNullableAllowed = false) {

    override fun get(bundle: Bundle, key: String): Planet? {
        return bundle.getParcelable(key)
    }

    override fun parseValue(value: String): Planet {
        return Gson().fromJson(value, Planet::class.java)
    }

    override fun put(bundle: Bundle, key: String, value: Planet) {
        bundle.putParcelable(key, value)
    }
}
