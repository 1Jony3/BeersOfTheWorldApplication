package ru.cft.shift2021summer.feature.breweries.domain

import retrofit2.Response

interface BeersRepository {

    suspend fun getAll(): Response<List<Beers>>

    suspend fun get(id: Long): Response<List<Beers>>

    suspend fun getName(name: String): Response<List<Beers>>



}