package com.esaudiaz.larashopmovil.features.login.domain.entities

data class AuthToken(
    val accessToken: String,
    val tokenType: String
)