package com.esaudiaz.larashopmovil.features.employee.di

import com.esaudiaz.larashopmovil.core.di.AppContainer
import com.esaudiaz.larashopmovil.features.employee.data.repositories.EmpleadosRepositoryImpl
import com.esaudiaz.larashopmovil.features.employee.domain.entities.Empleado
import com.esaudiaz.larashopmovil.features.employee.domain.repositories.EmpleadosRepository
import com.esaudiaz.larashopmovil.features.employee.domain.usecases.CreateEmpleadoUseCase
import com.esaudiaz.larashopmovil.features.employee.domain.usecases.DeleteEmpleadoUseCase
import com.esaudiaz.larashopmovil.features.employee.domain.usecases.GetAllEmpleadosUseCase
import com.esaudiaz.larashopmovil.features.employee.domain.usecases.UpdateEmpleadoUseCase
import com.esaudiaz.larashopmovil.features.employee.presentation.viewmodels.EmpleadoFormViewModelFactory
import com.esaudiaz.larashopmovil.features.employee.presentation.viewmodels.EmpleadosViewModelFactory

class EmpleadosModule(
    private val appContainer: AppContainer
) {

    private fun provideEmpleadosRepository(): EmpleadosRepository {
        return EmpleadosRepositoryImpl(appContainer.empleadosApi)
    }

    private fun provideGetAllEmpleadosUseCase(): GetAllEmpleadosUseCase {
        return GetAllEmpleadosUseCase(provideEmpleadosRepository())
    }

    private fun provideCreateEmpleadoUseCase(): CreateEmpleadoUseCase {
        return CreateEmpleadoUseCase(provideEmpleadosRepository())
    }

    private fun provideUpdateEmpleadoUseCase(): UpdateEmpleadoUseCase {
        return UpdateEmpleadoUseCase(provideEmpleadosRepository())
    }

    private fun provideDeleteEmpleadoUseCase(): DeleteEmpleadoUseCase {
        return DeleteEmpleadoUseCase(provideEmpleadosRepository())
    }

    fun provideEmpleadosViewModelFactory(): EmpleadosViewModelFactory {
        return EmpleadosViewModelFactory(
            getAllEmpleadosUseCase = provideGetAllEmpleadosUseCase(),
            updateEmpleadoUseCase = provideUpdateEmpleadoUseCase(),
            deleteEmpleadoUseCase = provideDeleteEmpleadoUseCase()
        )
    }

    // Factory para el formulario
    fun provideEmpleadoFormViewModelFactory(empleado: Empleado?): EmpleadoFormViewModelFactory {
        return EmpleadoFormViewModelFactory(
            createEmpleadoUseCase = provideCreateEmpleadoUseCase(),
            updateEmpleadoUseCase = provideUpdateEmpleadoUseCase(),
            empleadoToEdit = empleado
        )
    }
}