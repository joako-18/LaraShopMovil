package com.esaudiaz.larashopmovil.features.employee.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.esaudiaz.larashopmovil.features.employee.domain.entities.Empleado
import com.esaudiaz.larashopmovil.features.employee.domain.usecases.CreateEmpleadoUseCase
import com.esaudiaz.larashopmovil.features.employee.domain.usecases.UpdateEmpleadoUseCase

class EmpleadoFormViewModelFactory(
    private val createEmpleadoUseCase: CreateEmpleadoUseCase,
    private val updateEmpleadoUseCase: UpdateEmpleadoUseCase,
    private val empleadoToEdit: Empleado? = null
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EmpleadoFormViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return EmpleadoFormViewModel(
                createEmpleadoUseCase,
                updateEmpleadoUseCase,
                empleadoToEdit
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
    }
}