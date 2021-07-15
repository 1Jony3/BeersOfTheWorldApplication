package ru.cft.shift2021summer.feature.breweries.data

import retrofit2.Response
import ru.cft.shift2021summer.feature.breweries.domain.Beers
import ru.cft.shift2021summer.feature.breweries.domain.BeersRepository

class BeersRepositoryImpl(private val breweriesDatasource: BreweriesInMemoryDatasource): BeersRepository {


    override suspend fun getAll(): Response<List<Beers>> = breweriesDatasource.getAll()

    override suspend fun get(id: Long): Response<List<Beers>> = breweriesDatasource.get(id)

    override suspend fun getName(name: String): Response<List<Beers>> = breweriesDatasource.getName(name)


}