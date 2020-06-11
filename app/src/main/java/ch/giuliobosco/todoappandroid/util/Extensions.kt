package ch.giuliobosco.todoappandroid.util

import com.google.android.material.snackbar.Snackbar

fun Snackbar.color(color: Int):Snackbar {
    view.setBackgroundColor(color)
    return this
}