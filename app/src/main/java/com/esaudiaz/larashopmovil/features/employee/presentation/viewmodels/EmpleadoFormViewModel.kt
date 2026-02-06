package com.esaudiaz.larashopmovil.features.employee.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.esaudiaz.larashopmovil.features.employee.domain.entities.Empleado
import com.esaudiaz.larashopmovil.features.employee.domain.entities.EmpleadoCreate
import com.esaudiaz.larashopmovil.features.employee.domain.entities.EmpleadoUpdate
import com.esaudiaz.larashopmovil.features.employee.domain.usecases.CreateEmpleadoUseCase
import com.esaudiaz.larashopmovil.features.employee.domain.usecases.UpdateEmpleadoUseCase
import com.esaudiaz.larashopmovil.features.employee.presentation.screens.EmpleadoFormUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class EmpleadoFormViewModel(
    private val createEmpleadoUseCase: CreateEmpleadoUseCase,
    private val updateEmpleadoUseCase: UpdateEmpleadoUseCase,
    private val empleadoToEdit: Empleado? = null
) : ViewModel() {

    private val _uiState = MutableStateFlow(EmpleadoFormUiState())
    val uiState = _uiState.asStateFlow()

    val isEditMode = empleadoToEdit != null

    init {
        empleadoToEdit?.let { empleado ->
            _uiState.update {
                it.copy(
                    nombre = empleado.nombre,
                    correo = empleado.correo,
                    telefono = empleado.telefono ?: "",
                    idTelegram = empleado.idTelegram?.toString() ?: "",
                    rol = empleado.rol
                )
            }
        }
    }

    fun updateNombre(nombre: String) {
        _uiState.update { it.copy(nombre = nombre, error = null) }
    }

    fun updateCorreo(correo: String) {
        _uiState.update { it.copy(correo = correo, error = null) }
    }

    fun updateTelefono(telefono: String) {
        _uiState.update { it.copy(telefono = telefono, error = null) }
    }

    fun updateIdTelegram(id: String) {
        _uiState.update { it.copy(idTelegram = id, error = null) }
    }

    fun updateRol(rol: String) {
        _uiState.update { it.copy(rol = rol, error = null) }
    }

    fun updateContrasena(contrasena: String) {
        _uiState.update {
            it.copy(
                contrasena = contrasena,
                error = null,
                showPasswordError = false
            )
        }
    }

    fun updateConfirmarContrasena(confirmar: String) {
        _uiState.update {
            it.copy(
                confirmarContrasena = confirmar,
                error = null,
                showPasswordError = false
            )
        }
    }

    fun togglePasswordVisibility() {
        _uiState.update { it.copy(isPasswordVisible = !it.isPasswordVisible) }
    }

    fun toggleConfirmPasswordVisibility() {
        _uiState.update { it.copy(isConfirmPasswordVisible = !it.isConfirmPasswordVisible) }
    }

    fun save(onSuccess: () -> Unit) {
        val state = _uiState.value

        // Validar contraseñas solo en modo crear o si se está cambiando
        if (!isEditMode || state.contrasena.isNotEmpty()) {
            if (state.contrasena != state.confirmarContrasena) {
                _uiState.update {
                    it.copy(
                        error = "Las contraseñas no coinciden",
                        showPasswordError = true
                    )
                }
                return
            }

            if (!isEditMode && state.contrasena.length < 8) {
                _uiState.update {
                    it.copy(
                        error = "La contraseña debe tener al menos 8 caracteres",
                        showPasswordError = true
                    )
                }
                return
            }
        }

        _uiState.update { it.copy(isLoading = true, error = null) }

        viewModelScope.launch {
            val result = if (isEditMode) {
                updateEmpleado()
            } else {
                createEmpleado()
            }

            result.fold(
                onSuccess = {
                    _uiState.update { it.copy(isLoading = false) }
                    onSuccess()
                },
                onFailure = { error ->
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            error = error.message ?: "Error al guardar empleado"
                        )
                    }
                }
            )
        }
    }

    private suspend fun createEmpleado(): Result<Empleado> {
        val state = _uiState.value
        val telegramId = state.idTelegram.toLongOrNull()

        val empleado = EmpleadoCreate(
            nombre = state.nombre,
            correo = state.correo,
            telefono = state.telefono.ifBlank { null },
            idTelegram = telegramId,
            rol = state.rol,
            estado = "activo",
            contrasena = state.contrasena
        )

        return createEmpleadoUseCase(empleado)
    }

    private suspend fun updateEmpleado(): Result<Empleado> {
        val state = _uiState.value
        val telegramId = state.idTelegram.toLongOrNull()

        val empleado = EmpleadoUpdate(
            nombre = state.nombre,
            correo = state.correo,
            telefono = state.telefono.ifBlank { null },
            idTelegram = telegramId,
            rol = state.rol,
            contrasena = if (state.contrasena.isNotEmpty()) state.contrasena else null
        )

        return updateEmpleadoUseCase(empleadoToEdit!!.id, empleado)
    }

    fun clearError() {
        _uiState.update { it.copy(error = null, showPasswordError = false) }
    }
}