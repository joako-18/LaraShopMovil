package com.esaudiaz.larashopmovil

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import com.esaudiaz.larashopmovil.features.categorias.di.CategoriasContainer
import com.esaudiaz.larashopmovil.core.ui.theme.LaraShopMovilTheme
import com.esaudiaz.larashopmovil.features.categorias.presentation.screens.CategoriasScreen
import com.esaudiaz.larashopmovil.features.categorias.presentation.viewmodels.CategoriaViewModel
import com.esaudiaz.larashopmovil.features.categorias.presentation.viewmodels.CategoriaViewModelFactory
import kotlinx.coroutines.launch

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
            LaraShopMovilTheme {
                CategoriasScreen(
                    viewModel = viewModel,
                    onCreate = {

                    }, onEdit ={ categoria ->

                }
                )
            }
        }
    }
}


