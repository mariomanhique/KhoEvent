package com.mariomanhique.khoevent.model

data class AuthenticationRequest(
    val email: String,
    val password: String
)

data class TokenResponse(
    val accessToken: String
)