package com.esaudiaz.larashopmovil.features.employee.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.esaudiaz.larashopmovil.features.employee.domain.usecases.DeleteEmpleadoUseCase
import com.esaudiaz.larashopmovil.features.employee.domain.usecases.GetAllEmpleadosUseCase
import com.esaudiaz.larashopmovil.features.employee.domain.usecases.UpdateEmpleadoUseCase
import com.esaudiaz.larashopmovil.features.employee.presentation.screens.EmpleadosUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class EmpleadosViewModel(
    private val getAllEmpleadosUseCase: GetAllEmpleadosUseCase,
    private val updateEmpleadoUseCase: UpdateEmpleadoUseCase,
    private val deleteEmpleadoUseCase: DeleteEmpleadoUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(EmpleadosUiState())
    val uiState = _uiState.asStateFlow()

    init {
        loadEmpleados()
    }

    fun loadEmpleados() {
        _uiState.update { it.copy(isLoading = true, error = null) }

        viewModelScope.launch {
            val result = getAllEmpleadosUseCase()
            _uiState.update { currentState ->
                result.fold(
                    onSuccess = { empleados ->
                        currentState.copy(
                            isLoading = false,
                            empleados = empleados
                        )
                    },
                    onFailure = { error ->
                        currentState.copy(
                            isLoading = false,
                            error = error.message ?: "Error al cargar empleados"
                        )
                    }
                )
            }
        }
    }

    fun toggleEstadoEmpleado(empleadoId: Int, estadoActual: String) {
        viewModelScope.launch {
            val nuevoEstado = if (estadoActual == "activo") "inactivo" else "activo"

            val empleadoUpdate = com.esaudiaz.larashopmovil.features.employee.domain.entities.EmpleadoUpdate(
                estado = nuevoEstado
            )

            val result = updateEmpleadoUseCase(empleadoId, empleadoUpdate)
            result.fold(
                onSuccess = { loadEmpleados() },
                onFailure = { error ->
                    _uiState.update { it.copy(error = error.message) }
                }
            )
        }
    }

    fun deleteEmpleado(empleadoId: Int) {
        viewModelScope.launch {
            val result = deleteEmpleadoUseCase(empleadoId)
            result.fold(
                onSuccess = { loadEmpleados() },
                onFailure = { error ->
                    _uiState.update { it.copy(error = error.message) }
                }
            )
        }
    }

    fun showEditDialog(empleado: com.esaudiaz.larashopmovil.features.employee.domain.entities.Empleado) {
        _uiState.update {
            it.copy(
                showEditDialog = true,
                selectedEmpleado = empleado
            )
        }
    }

    fun hideEditDialog() {
        _uiState.update {
            it.copy(
                showEditDialog = false,
                selectedEmpleado = null
            )
        }
    }

    fun showCreateDialog() {
        _uiState.update { it.copy(showCreateDialog = true) }
    }

    fun hideCreateDialog() {
        _uiState.update { it.copy(showCreateDialog = false) }
    }

    fun clearError() {
        _uiState.update { it.copy(error = null) }
    }
}