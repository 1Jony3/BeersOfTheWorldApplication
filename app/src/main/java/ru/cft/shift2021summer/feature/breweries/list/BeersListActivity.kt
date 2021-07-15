package ru.cft.shift2021summer.feature.breweries.list

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import ru.cft.shift2021summer.R
import ru.cft.shift2021summer.feature.breweries.details.presentation.BeersDetailsActivity
import ru.cft.shift2021summer.feature.breweries.domain.Beers
import ru.cft.shift2021summer.feature.breweries.domain.DialogAddBeers
import ru.cft.shift2021summer.feature.breweries.domain.DialogSearchBeers

class BeersListActivity : AppCompatActivity() {



    private val adapter = BeersAdapter{ viewModel.openBreweriesDetailsScreen(it) }

    private  val viewModel: ListViewModel by viewModels {
        BreweriesViewModelFactory(application)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beers_list)



        viewModel.breweries.observe(this, ::bindBreweries)
        viewModel.openDetailsScreenEvent.observe(this, ::openDetailsScreen)



        val breweriesList = findViewById<RecyclerView>(R.id.breweriesList)
        breweriesList.adapter = adapter
    }

    private fun bindBreweries(list: List<Beers>) {
        adapter.breweries = list
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadBreweries()
    }

    fun showDialogAdd(v: View?) {
        val dialog = DialogAddBeers()
        dialog.show(supportFragmentManager, "tag1")
    }

    fun showDialogSearch(v: View?) {
        val dialog = DialogSearchBeers()
        dialog.show(supportFragmentManager, "tag2")
    }

    private fun openDetailsScreen(breweriesId: Long) {
        BeersDetailsActivity.start(this, breweriesId)
    }

}