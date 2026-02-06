package com.esaudiaz.larashopmovil.features.login.presentation.screens

data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val error: String? = null,
    val isPasswordVisible: Boolean = false,
    val isLoginSuccessful: Boolean = false
)