package com.esaudiaz.larashopmovil.core.navigation

import androidx.compose.runtime.collectAsState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.esaudiaz.larashopmovil.features.categorias.presentation.screens.CategoriaFormScreen
import com.esaudiaz.larashopmovil.features.categorias.presentation.screens.CategoriasScreen
import com.esaudiaz.larashopmovil.features.categorias.presentation.viewmodels.CategoriaViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

fun NavGraphBuilder.categoriasGraph(
    navController: NavHostController,
    viewModel: CategoriaViewModel
) {

    composable(Screen.Categorias.route) {
        CategoriasScreen(
            viewModel = viewModel,
            onCreate = {
                navController.navigate(Screen.CrearCategoria.route)
            },
            onEdit = { categoria ->
                navController.navigate(
                    Screen.EditarCategoria.createRoute(categoria.id_categoria)
                )
            },
            onBack = {
                navController.popBackStack()
            }
        )
    }

    // Crear categoría
    composable(Screen.CrearCategoria.route) {
        CategoriaFormScreen(
            categoria = null,
            onSave = { nombre ->
                viewModel.createCategoria(nombre)
                navController.popBackStack()
            },
            onCancel = {
                navController.popBackStack()
            }
        )
    }

    // Editar categoría
    composable(
        route = Screen.EditarCategoria.route,
        arguments = listOf(
            navArgument("categoriaId") { type = NavType.IntType }
        )
    ) { backStackEntry ->
        val categoriaId = backStackEntry.arguments?.getInt("categoriaId")

        val uiState by viewModel.uiState.collectAsState()
        val categoria = uiState.categorias.find {
            it.id_categoria == categoriaId
        }

        CategoriaFormScreen(
            categoria = categoria,
            onSave = { nombre ->
                categoria?.let {
                    viewModel.updateCategoria(it.copy(nombre = nombre))
                }
                navController.popBackStack()
            },
            onCancel = {
                navController.popBackStack()
            }
        )
    }
}