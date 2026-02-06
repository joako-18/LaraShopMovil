package com.esaudiaz.larashopmovil.features.employee.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.esaudiaz.larashopmovil.features.employee.domain.usecases.DeleteEmpleadoUseCase
import com.esaudiaz.larashopmovil.features.employee.domain.usecases.GetAllEmpleadosUseCase
import com.esaudiaz.larashopmovil.features.employee.domain.usecases.UpdateEmpleadoUseCase

class EmpleadosViewModelFactory(
    private val getAllEmpleadosUseCase: GetAllEmpleadosUseCase,
    private val updateEmpleadoUseCase: UpdateEmpleadoUseCase,
    private val deleteEmpleadoUseCase: DeleteEmpleadoUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EmpleadosViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return EmpleadosViewModel(
                getAllEmpleadosUseCase,
                updateEmpleadoUseCase,
                deleteEmpleadoUseCase
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
    }
}