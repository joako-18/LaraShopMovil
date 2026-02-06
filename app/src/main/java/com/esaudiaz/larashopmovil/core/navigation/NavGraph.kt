package com.esaudiaz.larashopmovil.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.esaudiaz.larashopmovil.features.categorias.presentation.viewmodels.CategoriaViewModel

@Composable
fun AppNavGraph(
    navController: NavHostController,
    startDestination: String = Screen.Login.route,
    categoriaViewModel: CategoriaViewModel
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        // ============ AUTH GRAPH ============
        authGraph(navController)

        // ============ MAIN APP GRAPH ============
        mainGraph(navController)

        // ============ CATEGORIAS GRAPH ============
        categoriasGraph(navController, categoriaViewModel)

    }
}