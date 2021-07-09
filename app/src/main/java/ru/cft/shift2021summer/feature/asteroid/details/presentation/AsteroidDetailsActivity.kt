package ru.cft.shift2021summer.feature.asteroid.details.presentation

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import ru.cft.shift2021summer.R
import ru.cft.shift2021summer.feature.asteroid.Asteroid


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

    private val viewModel: DetailsViewModel by viewModels {
        DetailsViewModelFactory(application, intent.getLongExtra(EXTRA_ID, 0))
    }

    private lateinit var nameText: TextView
    private lateinit var weightText: TextView
    private lateinit var densityText: TextView
    private lateinit var temperatureText: TextView
    private lateinit var dangerousEditText: EditText
    private lateinit var saveButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_asteroid_details)

        nameText = findViewById(R.id.nameText)
        weightText = findViewById(R.id.weightText)
        densityText = findViewById(R.id.densityText)
        temperatureText = findViewById(R.id.temperatureText)
        dangerousEditText = findViewById(R.id.dangerousEditText)
        saveButton = findViewById(R.id.saveButton)

        viewModel.asteroid.observe(this, ::bindAsteroid)
        viewModel.closeScreenEvent.observe(this) { closeScreen() }
    }

    private fun bindAsteroid(asteroid: Asteroid){
        nameText.text = getString(R.string.name_format, asteroid.name)
        weightText.text = getString(R.string.weight_format, asteroid.weight)
        densityText.text = getString(R.string.density_format, asteroid.density)
        temperatureText.text = getString(R.string.temperature_format, asteroid.temperature.joinToString(", "))
        dangerousEditText.setText(asteroid.dangerous)

        saveButton.setOnClickListener {
            val updatedAsteroid = if (dangerousEditText.text.toString() == "") asteroid.copy(dangerous = "Unknown")
            else asteroid.copy(dangerous = dangerousEditText.text.toString())
            viewModel.saveAsteroid(updatedAsteroid)
            val toast = Toast.makeText(this, "save", Toast.LENGTH_LONG)
            toast.show()
        }
    }

    private fun  closeScreen() {
        finish()
    }
}
