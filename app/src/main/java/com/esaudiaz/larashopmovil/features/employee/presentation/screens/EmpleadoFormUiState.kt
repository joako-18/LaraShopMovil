package com.esaudiaz.larashopmovil.features.employee.presentation.screens

data class EmpleadoFormUiState(
    val nombre: String = "",
    val correo: String = "",
    val telefono: String = "",
    val idTelegram: String = "",
    val rol: String = "empleado",
    val contrasena: String = "",
    val confirmarContrasena: String = "",
    val isPasswordVisible: Boolean = false,
    val isConfirmPasswordVisible: Boolean = false,
    val isLoading: Boolean = false,
    val error: String? = null,
    val showPasswordError: Boolean = false
)