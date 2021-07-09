package ru.cft.shift2021summer.feature.asteroid.details.presentation

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.cft.shift2021summer.app.BreakingBadApplication
import ru.cft.shift2021summer.feature.asteroid.details.domain.GetAsteroidUseCase
import ru.cft.shift2021summer.feature.asteroid.details.domain.SetAsteroidUseCase

class DetailsViewModelFactory (
    private val application: Application,
    private val asteroidId: Long) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val repository = (application as BreakingBadApplication).asteroidRepository
        return DetailsViewModel(
            GetAsteroidUseCase(repository),
            SetAsteroidUseCase(repository),
            asteroidId
        ) as T
    }
}