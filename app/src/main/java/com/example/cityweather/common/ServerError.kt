package com.example.cityweather.common

import android.content.Context
import android.widget.Toast

object ServerError {
    fun handleServerError(status: String, context: Context) {
        if (status != "OK") {
            Toast.makeText(context, "Some server error", Toast.LENGTH_SHORT).show()
        }
    }
}