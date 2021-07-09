package ru.cft.shift2021summer.feature.asteroid.details.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.cft.shift2021summer.events.LiveEvent
import ru.cft.shift2021summer.feature.asteroid.details.domain.GetAsteroidUseCase
import ru.cft.shift2021summer.feature.asteroid.details.domain.SetAsteroidUseCase
import ru.cft.shift2021summer.feature.asteroid.Asteroid

class DetailsViewModel (
    getUseCase: GetAsteroidUseCase,
    private val setUseCase: SetAsteroidUseCase,
    asteroidId: Long
    ):ViewModel() {
    val asteroid = MutableLiveData<Asteroid>()
    val closeScreenEvent = LiveEvent()

    fun saveAsteroid(asteroid: Asteroid) {
        setUseCase(asteroid)
        closeScreenEvent()
    }

    init {
        if ((getUseCase(asteroidId)) != null) {
            this.asteroid.value = getUseCase(asteroidId)
        } else {
            closeScreenEvent()
        }
    }
}