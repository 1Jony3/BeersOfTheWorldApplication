package ru.cft.shift2021summer.feature.breweries.domain

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import ru.cft.shift2021summer.R


class DialogAddBeers(): DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder = AlertDialog.Builder(activity)
        return builder
            .setTitle("Add breweries")
            .setView(R.layout.add_beers)
            .setPositiveButton("Add") { dialog, id ->
                OnClickAdd()
            }
            .setNegativeButton("Cancel", null)
            .create();
    }

    fun OnClickAdd() {

    }
}

