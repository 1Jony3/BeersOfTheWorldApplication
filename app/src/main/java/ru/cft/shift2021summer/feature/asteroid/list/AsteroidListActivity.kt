package ru.cft.shift2021summer.feature.asteroid.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.RecyclerView
import ru.cft.shift2021summer.R
import ru.cft.shift2021summer.feature.asteroid.Asteroid
import ru.cft.shift2021summer.feature.asteroid.details.presentation.AsteroidDetailsActivity

class AsteroidListActivity : AppCompatActivity() {
    private val adapter = AsteroidAdapter {
        viewModel.openAsteroidDetailsScreen(it)
    }

    private  val viewModel: ListViewModel by viewModels {
        AsteroidViewModelFactory(application)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_asteroid_list)
        viewModel.asteroid.observe(this, ::bindAsteroid)
        viewModel.openDetailsScreenEvent.observe(this, ::openDetailsScreen)

        val asteroidList = findViewById<RecyclerView>(R.id.asteroidList)
        asteroidList.adapter = adapter
    }

    private fun bindAsteroid(list: List<Asteroid>) {
        adapter.asteroid = list
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadAsteroid()
    }

    private fun openDetailsScreen(asteroidId: Long) {
        AsteroidDetailsActivity.start(this, asteroidId)
    }

}