package ru.cft.shift2021summer.feature.asteroid.details.domain

import ru.cft.shift2021summer.feature.asteroid.Asteroid
import ru.cft.shift2021summer.feature.asteroid.domain.AsteroidRepository

class SetAsteroidUseCase(private val asteroidRepository: AsteroidRepository) {

    operator fun invoke(asteroid: Asteroid) {
        asteroidRepository.set(asteroid)
    }
}