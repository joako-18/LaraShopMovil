package com.esaudiaz.larashopmovil.features.login.domain.repositories

import com.esaudiaz.larashopmovil.features.login.domain.entities.AuthToken

interface AuthRepository {
    suspend fun login(email: String, password: String): AuthToken
    fun logout()
    fun isLoggedIn(): Boolean
    fun getToken(): String?
}