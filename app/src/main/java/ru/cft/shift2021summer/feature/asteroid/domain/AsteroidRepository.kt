package ru.cft.shift2021summer.feature.asteroid.domain

import ru.cft.shift2021summer.feature.asteroid.Asteroid

interface AsteroidRepository {

    fun getAll(): List<Asteroid>

    fun get(id: Long): Asteroid?

    fun set(character: Asteroid)
}