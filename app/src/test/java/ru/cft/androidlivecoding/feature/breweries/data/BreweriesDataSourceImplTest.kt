package ru.cft.androidlivecoding.feature.breweries.data

import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Response
import ru.cft.androidlivecoding.feature.breweries.TestEntities.ALL_BREWERIES
import ru.cft.androidlivecoding.feature.breweries.TestEntities.BREWERIES_1
import ru.cft.androidlivecoding.feature.breweries.TestEntities.BREWERIES_ID
import ru.cft.shift2021summer.feature.breweries.data.BeersAPI
import ru.cft.shift2021summer.feature.breweries.data.BreweriesInMemoryDatasourceImpl

@RunWith(MockitoJUnitRunner::class)
class CharactersDataSourceImplTest {

    private val api: BeersAPI = mockk {
        coEvery { get(BREWERIES_ID) } returns Response.success(BREWERIES_1)
        coEvery { getAll() } returns Response.success(ALL_BREWERIES)
    }

    private val dataSource = BreweriesInMemoryDatasourceImpl(api)

    @Test
    fun `get character EXPECT character from api`() = runBlocking {
        assertEquals(dataSource.get(BREWERIES_ID).body(), BREWERIES_1)
    }

    @Test
    fun `get all character EXPECT all character from api`() = runBlocking {
        assertEquals(dataSource.getAll().body(), ALL_BREWERIES)
    }
}