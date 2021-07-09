package ru.cft.shift2021summer.feature.asteroid.data

import ru.cft.shift2021summer.feature.asteroid.Asteroid
import ru.cft.shift2021summer.feature.asteroid.domain.AsteroidRepository

class AsteroidRepositoryImpl(private val asteroidInMemoryDatasource: AsteroidInMemoryDatasource) :
    AsteroidRepository {


    override fun getAll(): List<Asteroid> = asteroidInMemoryDatasource.getAll()

    override fun get(id: Long): Asteroid? = asteroidInMemoryDatasource.get(id)

    override fun set(asteroid: Asteroid) = asteroidInMemoryDatasource.set(asteroid)
}