package ru.cft.shift2021summer.feature.breweries.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import ru.cft.shift2021summer.feature.breweries.domain.Beers

interface BeersAPI {

    @GET("beers")
    suspend fun getAll(): Response<List<Beers>>
    @GET("beers/{id}")
    suspend fun get(@Path("id") id: Long): Response<List<Beers>>
    @GET("?beer_name={name}")
    suspend fun getName(@Path("name") name: String): Response<List<Beers>>


}