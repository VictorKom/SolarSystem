package com.example.solarsystem.domain

import com.example.solarsystem.data.Repository
import com.example.solarsystem.domain.util.lce
import javax.inject.Inject

class InteractorImpl @Inject constructor(private val repository: Repository) : Interactor {

    override fun getPlanets() = lce { repository.getPlanets() }
}
