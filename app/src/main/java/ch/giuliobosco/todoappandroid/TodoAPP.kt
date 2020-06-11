package ch.giuliobosco.todoappandroid

import android.app.Application
import android.content.Context

class TodoAPP : Application() {
    init {
        instance = this
    }

    companion object {
        private var instance: TodoAPP? = null

        fun applicationContext(): Context {
            return instance!!.applicationContext
        }
    }
}