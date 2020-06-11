package ch.giuliobosco.todoappandroid.model.responses

data class LoginTokenResponse(
    val expire: String,
    val token: String
)