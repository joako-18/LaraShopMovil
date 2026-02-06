package com.esaudiaz.larashopmovil.features.employee.presentation.screens

import com.esaudiaz.larashopmovil.features.employee.domain.entities.Empleado

data class EmpleadosUiState(
    val isLoading: Boolean = false,
    val empleados: List<Empleado> = emptyList(),
    val error: String? = null,
    val showCreateDialog: Boolean = false,
    val showEditDialog: Boolean = false,
    val selectedEmpleado: Empleado? = null
)