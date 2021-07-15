package ru.cft.shift2021summer.app

import android.app.Application
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import ru.cft.shift2021summer.feature.breweries.data.BeersRepositoryImpl
import ru.cft.shift2021summer.feature.breweries.data.BreweriesInMemoryDatasourceImpl
import ru.cft.shift2021summer.feature.breweries.domain.BeersRepository


class BeersOfTheWorldApplication : Application() {

    lateinit var beersRepository: BeersRepository
    private lateinit var retrofit: Retrofit

    private companion object {

        var BASE_URL = "https://api.punkapi.com/v2/"
    }

    override fun onCreate() {
        super.onCreate()
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
        beersRepository = BeersRepositoryImpl(BreweriesInMemoryDatasourceImpl(retrofit.create())
        )
    }
}

