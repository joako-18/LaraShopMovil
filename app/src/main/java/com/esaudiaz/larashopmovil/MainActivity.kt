package com.esaudiaz.larashopmovil


import android.os.Bundle
import com.esaudiaz.larashopmovil.core.navigation.Screen
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.navigation.compose.rememberNavController
import com.esaudiaz.larashopmovil.core.navigation.AppNavGraph
import com.esaudiaz.larashopmovil.core.ui.theme.LaraShopMovilTheme
import com.esaudiaz.larashopmovil.features.categorias.presentation.viewmodels.CategoriaViewModel


class MainActivity : ComponentActivity() {

    private val viewModel: CategoriaViewModel by viewModels {
        (application as LaraShopMovilApplication)
            .categoriasContainer
            .categoriaViewModelFactory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()



        setContent {
            val navController = rememberNavController()

            LaraShopMovilTheme {
                AppNavGraph(
                    navController = navController,
                    startDestination = Screen.Login.route,
                    categoriaViewModel = viewModel,
                )
            }
        }
    }
}


