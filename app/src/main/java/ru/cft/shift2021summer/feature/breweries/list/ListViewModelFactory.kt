package ru.cft.shift2021summer.feature.breweries.list

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.cft.shift2021summer.app.BeersOfTheWorldApplication

    class BreweriesViewModelFactory(private val application: Application) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ListViewModel((application as BeersOfTheWorldApplication).beersRepository) as T
    }
}