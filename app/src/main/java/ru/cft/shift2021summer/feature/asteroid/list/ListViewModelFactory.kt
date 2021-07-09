package ru.cft.shift2021summer.feature.asteroid.list

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.cft.shift2021summer.app.BreakingBadApplication

class AsteroidViewModelFactory(private val application: Application) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ListViewModel((application as BreakingBadApplication).asteroidRepository) as T
    }
}