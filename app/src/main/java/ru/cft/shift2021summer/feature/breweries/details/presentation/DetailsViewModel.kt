package ru.cft.shift2021summer.feature.breweries.details.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import ru.cft.shift2021summer.events.LiveEvent
import ru.cft.shift2021summer.events.SingleLiveEvent
import ru.cft.shift2021summer.feature.breweries.domain.Beers
import ru.cft.shift2021summer.feature.breweries.domain.BeersRepository

class DetailsViewModel(
    private val repository: BeersRepository,
    private val breweriesId: Long
    ):ViewModel() {

    val breweries = MutableLiveData<Beers>()
    val closeScreenEvent = LiveEvent()
    val loadError = SingleLiveEvent<String>()

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable -> loadError.postValue(throwable.message) }
    private var job: Job? = null


    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

    fun loadData() {
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response = repository.get(breweriesId)
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    breweries.value = response.body()?.get(0)
                } else {
                    loadError.value = "Error ${response.message()}"
                }
            }
        }
    }


}