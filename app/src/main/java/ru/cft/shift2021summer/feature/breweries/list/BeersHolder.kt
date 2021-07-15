package ru.cft.shift2021summer.feature.breweries.list

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import ru.cft.shift2021summer.R
import ru.cft.shift2021summer.feature.breweries.domain.Beers

class BeersHolder(private val onItemClick: (Beers) -> Unit, itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val nameText: TextView = itemView.findViewById(R.id.nameText)
    private val breweryTypeText: TextView = itemView.findViewById(R.id.breweryTypeText)
    private var image: ImageView = itemView.findViewById(R.id.image)
    private var glideManager: RequestManager = Glide.with(itemView.context)


    fun bind(beers: Beers) {
        beers.image_url?.let {
            glideManager.load(it).into(image)
        }
        nameText.text = "Name: " + beers.name
        breweryTypeText.text = "Type: " + beers.tagline
        itemView.setOnClickListener { onItemClick(beers) }
    }
}