package com.example.androidscaffolding.ui.Auth.fragment

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle

import androidx.fragment.app.DialogFragment

class OpeningDialogFragment : DialogFragment() {
        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
            return activity?.let {
                // Use the Builder class for convenient dialog construction.e
                val builder = AlertDialog.Builder(it)
                builder.setMessage("Start game")
                    .setPositiveButton("Start") { dialog, id ->
                        // START THE GAME!
                    }
                    .setNegativeButton("Cancel") { dialog, id ->
                        // User cancelled the dialog.
                    }
                // Create the AlertDialog object and return it.
                builder.create()
            } ?: throw IllegalStateException("Activity cannot be null")
        }

}