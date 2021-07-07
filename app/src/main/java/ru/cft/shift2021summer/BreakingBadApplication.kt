package ru.cft.shift2021summer

import android.app.Application

class BreakingBadApplication : Application() {
    lateinit var asteroidRepository: AsteroidRepository

    override fun onCreate() {
        super.onCreate()
        asteroidRepository = AsteroidRepository()
    }
}