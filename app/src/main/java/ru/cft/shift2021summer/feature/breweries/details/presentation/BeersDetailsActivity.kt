package ru.cft.shift2021summer.feature.breweries.details.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import ru.cft.shift2021summer.R
import ru.cft.shift2021summer.feature.breweries.domain.Beers


class BeersDetailsActivity : AppCompatActivity() {

    companion object {

        private const val EXTRA_ID = "EXTRA_ID"

        fun start(context: Context, id: Long) {
            val intent = Intent(context, BeersDetailsActivity::class.java).apply {
                putExtra(EXTRA_ID, id)
            }
            context.startActivity(intent)
        }
    }

    private val viewModel: DetailsViewModel by viewModels {
        DetailsViewModelFactory(application, intent.getLongExtra(EXTRA_ID, 0))
    }

    private lateinit var name: TextView
    private lateinit var tagline: TextView
    private lateinit var first_brewed: TextView
    private lateinit var description: TextView
    private lateinit var image: ImageView

    private lateinit var glideManager: RequestManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beers_details)

        viewModel.loadData()

        name = findViewById(R.id.nameText)
        tagline = findViewById(R.id.tagline_typeText)
        first_brewed = findViewById(R.id.first_brewedText)
        description = findViewById(R.id.descriptionText)
        glideManager = Glide.with(this)

        image = findViewById(R.id.image)

        viewModel.breweries.observe(this, ::bindAsteroid)
        viewModel.closeScreenEvent.observe(this) { closeScreen() }
    }

    private fun bindAsteroid(beers: Beers){
        name.text = getString(R.string.name_format, beers.name)
        tagline.text = getString(R.string.tagline_format, beers.tagline)
        first_brewed.text = getString(R.string.first_brewed_format, beers.first_brewed)
        description.text = getString(R.string.description_format, beers.description)
        beers.image_url?.let {
            glideManager.load(it).into(image)
        }
    }

    private fun  closeScreen() {
        finish()
    }
}
