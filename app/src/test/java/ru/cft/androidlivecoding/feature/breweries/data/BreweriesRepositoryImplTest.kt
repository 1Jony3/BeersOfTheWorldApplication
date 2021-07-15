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
import ru.cft.shift2021summer.feature.breweries.data.BreweriesInMemoryDatasource
import ru.cft.shift2021summer.feature.breweries.data.BeersRepositoryImpl

@RunWith(MockitoJUnitRunner::class)
class CharacterRepositoryImplTest {

    private val charactersDatasource: BreweriesInMemoryDatasource = mockk {
        coEvery { get(BREWERIES_ID) } returns Response.success(BREWERIES_1)
        coEvery { getAll() } returns Response.success(ALL_BREWERIES)
    }

    private val repository = BeersRepositoryImpl(charactersDatasource)

    @Test
    fun `get brewery EXPECT call get brewery datasource`() = runBlocking {
        assertEquals(repository.get(BREWERIES_ID).body(), BREWERIES_1)
    }

    @Test
    fun `get all breweries EXPECT call get all breweries datasource`() = runBlocking {
        assertEquals(repository.getAll().body(), ALL_BREWERIES)
    }
}