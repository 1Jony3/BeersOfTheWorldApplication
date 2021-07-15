package ru.cft.shift2021summer.feature.breweries.domain

import com.google.gson.annotations.SerializedName

data class Beers
(
    @SerializedName("id")
    val id: Long,
    val name: String,
    val tagline: String,
    val first_brewed: String,
    val description: String,
    val image_url: String? = null
)