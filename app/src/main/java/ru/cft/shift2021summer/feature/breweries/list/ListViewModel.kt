package ru.cft.shift2021summer.feature.breweries.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import ru.cft.shift2021summer.events.SingleLiveEvent
import ru.cft.shift2021summer.feature.breweries.domain.Beers
import ru.cft.shift2021summer.feature.breweries.domain.BeersRepository

class ListViewModel(private val beersRepository: BeersRepository): ViewModel() {

    val breweries = MutableLiveData<List<Beers>>()
    val openDetailsScreenEvent = SingleLiveEvent<Long>()
    private val loadError = SingleLiveEvent<String>()

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable -> loadError.postValue(throwable.message) }

    private var job: Job? = null

    fun loadBreweries(){
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response = beersRepository.getAll()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    breweries.value = response.body()
                } else {
                    loadError.value = "Error ${response.message()}"
                }
            }
        }
    }

    fun openBreweriesDetailsScreen(beers: Beers){
        openDetailsScreenEvent.value = beers.id
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}