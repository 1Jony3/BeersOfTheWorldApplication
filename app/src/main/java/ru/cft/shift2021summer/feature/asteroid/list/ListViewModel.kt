package ru.cft.shift2021summer.feature.asteroid.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.cft.shift2021summer.events.SingleLiveEvent
import ru.cft.shift2021summer.feature.asteroid.Asteroid
import ru.cft.shift2021summer.feature.asteroid.domain.AsteroidRepository

class ListViewModel(private val asteroidRepository: AsteroidRepository): ViewModel() {

    val asteroid = MutableLiveData<List<Asteroid>>()
    val openDetailsScreenEvent = SingleLiveEvent<Long>()

    fun loadAsteroid(){
        val asteroid = asteroidRepository.getAll()
        this.asteroid.value = asteroid
    }
    fun openAsteroidDetailsScreen(asteroid: Asteroid){
        openDetailsScreenEvent.value = asteroid.id
    }

}