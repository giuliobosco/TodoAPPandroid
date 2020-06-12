package ch.giuliobosco.todoappandroid.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.core.content.ContextCompat
import ch.giuliobosco.todoappandroid.R
import ch.giuliobosco.todoappandroid.ui.task.TaskActivity
import ch.giuliobosco.todoappandroid.util.MySharedPreferences
import ch.giuliobosco.todoappandroid.util.Validator
import ch.giuliobosco.todoappandroid.util.color
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginView {

    lateinit var presenter:LoginPresenter
    private val validator = Validator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        validator
            .add(inputUsername)
            .add(inputPassword)

        presenter = LoginPresenterImpl(this)
        checkLoginToken()
        setupToolbar()
        setupListener()
    }

    private fun setupToolbar() {
        setSupportActionBar(toolbarLogin)
        supportActionBar?.title = resources.getString(R.string.wellcome)
    }

    private fun setupListener() {
        inputPassword.editText?.setOnEditorActionListener{v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                signin(v)
                true
            }
            false
        }
    }

    private fun checkLoginToken() {
        val token = MySharedPreferences.getToken()
        if (!token!!.isEmpty()) {
            val intent = Intent(this, TaskActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun showProgress() {
        progressbar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressbar.visibility = View.GONE
    }

    override fun onSuccess() {
        val intent = Intent(this, TaskActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onError(code: Int, message: String) {
        Snackbar.make(loginCoordinator, message, Snackbar.LENGTH_LONG)
            .color(ContextCompat.getColor(this, R.color.colorAccent))
            .show()
    }

    fun signin(view:View) {
        val username = inputUsername.editText?.text.toString()
        val password = inputPassword.editText?.text.toString()

        if (validator.result()) presenter.login(username, password)
    }

    fun signup(view:View) {
        val intent = Intent(this, SignupActivity::class.java)
    }
}
