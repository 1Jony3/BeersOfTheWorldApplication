package ru.cft.shift2021summer.feature.breweries.domain

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import ru.cft.shift2021summer.R

class DialogSearchBeers: DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        return builder
            .setTitle("Search breweries")
            .setView(R.layout.search_beers_name)
            .setPositiveButton("Search") { dialog, id ->
                OnClickSearch()
            }
            .setNegativeButton("Cancel", null)
            .create();
    }

    fun OnClickSearch(){
    }
}