package ru.cft.shift2021summer.feature.asteroid.list

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.cft.shift2021summer.R
import ru.cft.shift2021summer.feature.asteroid.Asteroid

class AsteroidHolder(private val onItemClick: (Asteroid) -> Unit, itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val nameText: TextView = itemView.findViewById(R.id.nameText)
    private val dangerousText: TextView = itemView.findViewById(R.id.dangerousText)

    fun bind(asteroid: Asteroid) {
        nameText.text = "Name: " + asteroid.name
        dangerousText.text = "Dangerous: " + ((asteroid.dangerous)?:"Unknown")
        itemView.setOnClickListener { onItemClick(asteroid) }
    }
}