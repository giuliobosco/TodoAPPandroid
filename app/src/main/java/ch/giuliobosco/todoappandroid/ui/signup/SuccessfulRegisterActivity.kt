package ch.giuliobosco.todoappandroid.ui.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import ch.giuliobosco.todoappandroid.R
import ch.giuliobosco.todoappandroid.ui.login.LoginActivity

class SuccessfulRegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_successful_register)
    }

    fun backToSignin(view:View) {
        val intent : Intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}
