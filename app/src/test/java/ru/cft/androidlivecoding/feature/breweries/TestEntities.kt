package ru.cft.androidlivecoding.feature.breweries

import ru.cft.shift2021summer.feature.breweries.domain.Beers

object TestEntities {

    const val BREWERIES_ID = 1L
    const val BREWERIES_ID_ERROR = 2L

    val BREWERIES_1 = Beers(
        id = 1L,
        name = "Name1",
        tagline = "type1",
        first_brewed = "street1",
        description = "city1",
        image_url = "county_province1"
    )

    private val BREWERIES_2 = Beers(
        id = 2L,
        name = "Name2",
        tagline = "type2",
        first_brewed = "street2",
        description = "city2",
        image_url = "county_province2"
    )

    val ALL_BREWERIES = listOf(BREWERIES_1, BREWERIES_2)
}