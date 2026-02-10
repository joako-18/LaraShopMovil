package com.esaudiaz.larashopmovil.features.login.data.repositories

import com.esaudiaz.larashopmovil.core.auth.TokenManager
import com.esaudiaz.larashopmovil.core.network.AuthApi
import com.esaudiaz.larashopmovil.features.login.data.datasources.remote.mapper.toDomain
import com.esaudiaz.larashopmovil.features.login.domain.entities.AuthToken
import com.esaudiaz.larashopmovil.features.login.domain.repositories.AuthRepository

class AuthRepositoryImpl(
    private val authApi: AuthApi,
    private val tokenManager: TokenManager
) : AuthRepository {

    override suspend fun login(email: String, password: String): AuthToken {
        val response = authApi.login(username = email, password = password)
        val authToken = response.toDomain()

        tokenManager.saveToken(authToken.accessToken)

        return authToken
    }

    override fun logout() {
        tokenManager.clearToken()
    }

    override fun isLoggedIn(): Boolean {
        return tokenManager.isLoggedIn()
    }

    override fun getToken(): String? {
        return tokenManager.getToken()
    }
}