package ru.cft.shift2021summer

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class AsteroidDetailsActivity : AppCompatActivity() {
    companion object {

        private const val EXTRA_ID = "EXTRA_ID"

        fun start(context: Context, id: Long) {
            val intent = Intent(context, AsteroidDetailsActivity::class.java).apply {
                putExtra(EXTRA_ID, id)
            }
            context.startActivity(intent)
        }
    }

    private lateinit var asteroidRepository: AsteroidRepository

    private lateinit var nameText: TextView
    private lateinit var weightText: TextView
    private lateinit var densityText: TextView
    private lateinit var temperatureText: TextView
    private lateinit var dangerousEditText: EditText
    private lateinit var saveButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_asteroid_details)

        asteroidRepository = (application as BreakingBadApplication).asteroidRepository

        nameText = findViewById(R.id.nameText)
        weightText = findViewById(R.id.weightText)
        densityText = findViewById(R.id.densityText)
        temperatureText = findViewById(R.id.temperatureText)
        dangerousEditText = findViewById(R.id.dangerousEditText)
        saveButton = findViewById(R.id.saveButton)

        val id = intent.getLongExtra(EXTRA_ID, 0)
        val asteroid = asteroidRepository.get(id)

        if (asteroid != null) {
            nameText.text = getString(R.string.name_format, asteroid.name)
            weightText.text = getString(R.string.weight_format, asteroid.weight)
            densityText.text = getString(R.string.density_format, asteroid.density)
            temperatureText.text = getString(R.string.temperature_format, asteroid.temperature.joinToString(", "))
            dangerousEditText.setText(asteroid.dangerous)

            saveButton.setOnClickListener {
                val updatedAsteroid : Asteroid
                if (dangerousEditText.text.toString() == "") updatedAsteroid =asteroid.copy(dangerous = "Unknown")
                else updatedAsteroid = asteroid.copy(dangerous = dangerousEditText.text.toString())
                asteroidRepository.set(updatedAsteroid)
                val toast = Toast.makeText(this, "save", Toast.LENGTH_LONG)
                toast.show()
                finish()
            }
        } else {
            finish()
        }
    }
}