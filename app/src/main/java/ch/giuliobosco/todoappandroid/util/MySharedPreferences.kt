package ch.giuliobosco.todoappandroid.util

import android.content.Context
import android.content.SharedPreferences
import ch.giuliobosco.todoappandroid.TodoAPP

object MySharedPreferences {
    private val sharedPreferences: SharedPreferences =
        TodoAPP.applicationContext()
            .getSharedPreferences(SHARED_PREFERENCE_FILE, Context.MODE_PRIVATE)

    fun getToken(): String? =
        sharedPreferences.getString(SP_TOKEN, "")

    fun saveToken(token: String) =
        sharedPreferences.edit().putString(SP_TOKEN, token).apply()

    fun clearToken() =
        sharedPreferences.edit().putString(SP_TOKEN, "").apply()
}