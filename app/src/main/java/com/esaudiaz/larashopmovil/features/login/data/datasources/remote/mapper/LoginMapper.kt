package com.esaudiaz.larashopmovil.features.login.data.datasources.remote.mapper

import com.esaudiaz.larashopmovil.core.network.models.TokenResponse
import com.esaudiaz.larashopmovil.features.login.domain.entities.AuthToken

fun TokenResponse.toDomain(): AuthToken {
    return AuthToken(
        accessToken = this.accessToken,
        tokenType = this.tokenType
    )
}