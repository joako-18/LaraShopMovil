package com.esaudiaz.larashopmovil.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.esaudiaz.larashopmovil.features.categorias.presentation.viewmodels.CategoriaViewModel
import com.esaudiaz.larashopmovil.features.employee.di.EmpleadosModule
import com.esaudiaz.larashopmovil.features.login.presentation.viewmodels.LoginViewModelFactory

@Composable
fun AppNavGraph(
    navController: NavHostController,
    startDestination: String = Screen.Login.route,
    loginViewModelFactory: LoginViewModelFactory,
    categoriaViewModel: CategoriaViewModel,
    empleadosModule: EmpleadosModule // Recibimos el módulo completo
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        // ============ AUTH GRAPH ============
        authGraph(
            navController = navController,
            loginViewModelFactory = loginViewModelFactory
        )

        // ============ MAIN APP GRAPH ============
        mainGraph(
            navController = navController,
            onLogout = {
                // Limpiar token (opcional aquí o en ViewModel) y volver al login
                navController.navigate(Screen.Login.route) {
                    popUpTo(0) { inclusive = true }
                }
            }
        )

        // ============ CATEGORIAS GRAPH ============
        categoriasGraph(
            navController = navController,
            viewModel = categoriaViewModel
        )

        // ============ EMPLEADOS GRAPH ============
        // Ahora pasamos el módulo completo como solicitaste
        empleadosGraph(
            navController = navController,
            empleadosModule = empleadosModule
        )
    }
}