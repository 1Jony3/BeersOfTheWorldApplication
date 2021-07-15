package ru.cft.shift2021summer.feature.breweries.details.presentation

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.cft.shift2021summer.app.BeersOfTheWorldApplication

class DetailsViewModelFactory (
    private val application: Application,
    private val breweriesId: Long) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DetailsViewModel(
            (application as BeersOfTheWorldApplication).beersRepository,
            breweriesId
        ) as T
    }
}