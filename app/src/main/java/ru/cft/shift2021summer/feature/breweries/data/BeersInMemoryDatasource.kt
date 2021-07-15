package ru.cft.shift2021summer.feature.breweries.data

import retrofit2.Response
import ru.cft.shift2021summer.feature.breweries.domain.Beers

interface BreweriesInMemoryDatasource {

    suspend fun getAll(): Response<List<Beers>>

    suspend fun get(id: Long): Response<List<Beers>>

    suspend fun getName(name: String): Response<List<Beers>>



}

class BreweriesInMemoryDatasourceImpl(private val beersApi: BeersAPI): BreweriesInMemoryDatasource {

    override suspend fun getAll(): Response<List<Beers>> = beersApi.getAll()

    override suspend fun get(id: Long): Response<List<Beers>> = beersApi.get(id)

    override suspend fun getName(name: String): Response<List<Beers>> = beersApi.getName(name)



}