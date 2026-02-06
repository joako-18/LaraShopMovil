package com.esaudiaz.larashopmovil.core.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.esaudiaz.larashopmovil.features.employee.di.EmpleadosModule
import com.esaudiaz.larashopmovil.features.employee.presentation.screens.EmpleadosScreen
import com.esaudiaz.larashopmovil.features.employee.presentation.viewmodels.EmpleadosViewModelFactory

fun NavGraphBuilder.empleadosGraph(
    navController: NavHostController,
    empleadosModule: EmpleadosModule
) {
    composable(Screen.Empleados.route) {
        EmpleadosScreen(
            factory = empleadosModule.provideEmpleadosViewModelFactory(),
            formFactory = { empleado ->
                empleadosModule.provideEmpleadoFormViewModelFactory(empleado)
            }
        )
    }
}