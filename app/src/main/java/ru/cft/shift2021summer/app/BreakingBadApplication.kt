package ru.cft.shift2021summer.app

import android.app.Application
import ru.cft.shift2021summer.feature.asteroid.data.AsteroidInMemoryDatasource
import ru.cft.shift2021summer.feature.asteroid.data.AsteroidInMemoryDatasourceImpl
import ru.cft.shift2021summer.feature.asteroid.data.AsteroidRepositoryImpl
import ru.cft.shift2021summer.feature.asteroid.domain.AsteroidRepository

class BreakingBadApplication : Application() {
    lateinit var asteroidRepository: AsteroidRepository
    lateinit var asteroidLocalSourch: AsteroidInMemoryDatasource

    override fun onCreate() {
        super.onCreate()
        asteroidRepository = AsteroidRepositoryImpl(
            AsteroidInMemoryDatasourceImpl()
        )
    }
}