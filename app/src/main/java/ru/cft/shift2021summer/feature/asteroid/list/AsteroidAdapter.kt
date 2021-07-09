package ru.cft.shift2021summer.feature.asteroid.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.cft.shift2021summer.R
import ru.cft.shift2021summer.feature.asteroid.Asteroid

class AsteroidAdapter (private val onItemClick: (Asteroid) -> Unit) : RecyclerView.Adapter<AsteroidHolder>() {

    var asteroid: List<Asteroid> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AsteroidHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_asteroid, parent, false)
        return AsteroidHolder(onItemClick, view)
    }

    override fun onBindViewHolder(holder: AsteroidHolder, position: Int) {
        val asteroid = asteroid[position]
        holder.bind(asteroid)
    }

    override fun getItemCount(): Int = asteroid.size
}

