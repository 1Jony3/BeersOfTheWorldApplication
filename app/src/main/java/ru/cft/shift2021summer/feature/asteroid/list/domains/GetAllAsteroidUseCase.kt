package ru.cft.shift2021summer.feature.asteroid.list.domains

import ru.cft.shift2021summer.feature.asteroid.Asteroid
import ru.cft.shift2021summer.feature.asteroid.domain.AsteroidRepository

class GetAllAsteroidUseCase (private val asteroidRepository: AsteroidRepository) {

    operator fun invoke(asteroid: Asteroid): List<Asteroid> =
        asteroidRepository.getAll()
}