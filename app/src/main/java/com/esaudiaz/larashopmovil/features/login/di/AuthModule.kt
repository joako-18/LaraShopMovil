package com.esaudiaz.larashopmovil.features.login.di

import com.esaudiaz.larashopmovil.core.di.AppContainer
import com.esaudiaz.larashopmovil.features.login.data.repositories.AuthRepositoryImpl
import com.esaudiaz.larashopmovil.features.login.domain.repositories.AuthRepository
import com.esaudiaz.larashopmovil.features.login.domain.usecases.LoginUseCase
import com.esaudiaz.larashopmovil.features.login.presentation.viewmodels.LoginViewModelFactory

class AuthModule(
    private val appContainer: AppContainer
) {

    private fun provideAuthRepository(): AuthRepository {
        return AuthRepositoryImpl(
            authApi = appContainer.authApi,
            tokenManager = appContainer.tokenManager
        )
    }

    private fun provideLoginUseCase(): LoginUseCase {
        return LoginUseCase(provideAuthRepository())
    }

    fun provideLoginViewModelFactory(): LoginViewModelFactory {
        return LoginViewModelFactory(
            loginUseCase = provideLoginUseCase()
        )
    }
}