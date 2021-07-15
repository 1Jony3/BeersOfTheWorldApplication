package ru.cft.androidlivecoding.feature.breweries.details.presentatoin

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import okhttp3.MediaType
import okhttp3.ResponseBody
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Response
import ru.cft.androidlivecoding.feature.breweries.TestCoroutineRule
import ru.cft.androidlivecoding.feature.breweries.TestEntities.BREWERIES_1
import ru.cft.androidlivecoding.feature.breweries.TestEntities.BREWERIES_ID
import ru.cft.shift2021summer.feature.breweries.details.presentation.DetailsViewModel
import ru.cft.shift2021summer.feature.breweries.domain.Beers
import ru.cft.shift2021summer.feature.breweries.domain.BeersRepository

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class DetailsViewModelTest {

    private companion object {

        val ERROR_RESPONSE = Response.error<Beers>(
            403,
            ResponseBody.create(
                MediaType.parse("application/json"),
                "{\"key\":[\"somestuff\"]}"
            )
        )
    }

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    private lateinit var viewModel: DetailsViewModel

    private val beersObserver: Observer<Beers> = mockk()
    private val errorObserver: Observer<String> = mockk()

    private val repository: BeersRepository = mockk {
        coEvery { get(BREWERIES_ID) } returns Response.success(BREWERIES_1)
    }

    @Before
    fun setUp() {
        viewModel = DetailsViewModel(repository, BREWERIES_ID)

        viewModel.breweries.observeForever(beersObserver)
        viewModel.loadError.observeForever(errorObserver)
    }

    @Test
    fun `load data EXPECT load data from repository`() =
        testCoroutineRule.runBlockingTest {
            viewModel.loadData()

            verify { beersObserver.onChanged(BREWERIES_1) }
        }

    @Test
    fun `load data error EXPECT load error message`() =
        testCoroutineRule.runBlockingTest {
            coEvery { repository.get(BREWERIES_ID) } returns ERROR_RESPONSE

            viewModel.loadData()

            verify { errorObserver.onChanged("Error Response.error()") }
        }
}