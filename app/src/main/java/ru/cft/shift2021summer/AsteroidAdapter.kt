package ru.cft.shift2021summer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

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

class AsteroidHolder(private val onItemClick: (Asteroid) -> Unit, itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val nameText: TextView = itemView.findViewById(R.id.nameText)
    private val dangerousText: TextView = itemView.findViewById(R.id.dangerousText)

    fun bind(asteroid: Asteroid) {
        nameText.text = "Name: " + asteroid.name
        dangerousText.text = "Dangerous: " + ((asteroid.dangerous)?:"Unknown")
        itemView.setOnClickListener { onItemClick(asteroid) }
    }
}