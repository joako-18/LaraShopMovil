package com.esaudiaz.larashopmovil

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.navigation.compose.rememberNavController
import com.esaudiaz.larashopmovil.core.navigation.AppNavGraph
import com.esaudiaz.larashopmovil.core.navigation.Screen
import com.esaudiaz.larashopmovil.core.ui.theme.LaraShopMovilTheme
import com.esaudiaz.larashopmovil.features.categorias.presentation.viewmodels.CategoriaViewModel
import com.esaudiaz.larashopmovil.features.employee.di.EmpleadosModule
import com.esaudiaz.larashopmovil.features.login.di.AuthModule

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // 1. Obtener el contenedor principal de la Application
        val appContainer = (application as LaraShopMovilApplication).appContainer

        // 2. Inicializar Módulos
        val authModule = AuthModule(appContainer)
        val empleadosModule = EmpleadosModule(appContainer)

        // 3. Obtener CategoriaViewModel usando su propia factoría desde el container de categorías
        val categoriaViewModel: CategoriaViewModel by viewModels {
            (application as LaraShopMovilApplication)
                .categoriasContainer
                .categoriaViewModelFactory
        }

        setContent {
            val navController = rememberNavController()

            LaraShopMovilTheme {
                AppNavGraph(
                    navController = navController,
                    startDestination = Screen.Login.route,
                    loginViewModelFactory = authModule.provideLoginViewModelFactory(),
                    categoriaViewModel = categoriaViewModel,
                    empleadosModule = empleadosModule // Pasamos el módulo completo aquí
                )
            }
        }
    }
}