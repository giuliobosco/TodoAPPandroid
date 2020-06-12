package ch.giuliobosco.todoappandroid.ui.signup

import android.annotation.SuppressLint
import ch.giuliobosco.todoappandroid.repository.Repository
import ch.giuliobosco.todoappandroid.util.ApiError

class SignupInteractorImpl (val presenter:SignupPresenter) : SignupInteractor {
    @SuppressLint("CheckResult")
    override fun signup(username: String, password: String) {
        Repository.register(username,password)
            .subscribe({ presenter.onSuccess() }, { error ->
                val httpError = ApiError(error)
                presenter.onError(httpError.code, httpError.message)
            })
    }
}