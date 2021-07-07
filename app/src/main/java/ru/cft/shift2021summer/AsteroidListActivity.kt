package ru.cft.shift2021summer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class AsteroidListActivity : AppCompatActivity() {
    private val adapter = AsteroidAdapter {
        AsteroidDetailsActivity.start(this, it.id)
    }

    private lateinit var asteroidRepository: AsteroidRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_asteroid_list)

        asteroidRepository = (application as BreakingBadApplication).asteroidRepository

        val charactersList = findViewById<RecyclerView>(R.id.asteroidList)
        charactersList.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        adapter.asteroid = asteroidRepository.getAll()
    }
}