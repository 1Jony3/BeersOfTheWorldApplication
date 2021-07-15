package ru.cft.shift2021summer.feature.breweries.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.cft.shift2021summer.R
import ru.cft.shift2021summer.feature.breweries.domain.Beers

class BeersAdapter(private val onItemClick: (Beers) -> Unit) : RecyclerView.Adapter<BeersHolder>() {

    var breweries: List<Beers> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeersHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_beers, parent, false)
        return BeersHolder(onItemClick, view)
    }

    override fun onBindViewHolder(holder: BeersHolder, position: Int) {
        val breweries = breweries[position]
        holder.bind(breweries)
    }

    override fun getItemCount(): Int = breweries.size
}

