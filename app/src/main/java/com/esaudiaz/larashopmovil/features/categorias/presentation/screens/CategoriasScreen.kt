package com.esaudiaz.larashopmovil.features.categorias.presentation.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.esaudiaz.larashopmovil.features.categorias.domain.entities.CategoriaEntity
import com.esaudiaz.larashopmovil.features.categorias.presentation.components.CategoriaCard
import com.esaudiaz.larashopmovil.features.categorias.presentation.viewmodels.CategoriaViewModel
import androidx.compose.runtime.getValue

@Composable
fun CategoriasScreen(
    viewModel: CategoriaViewModel,
    onCreate: () -> Unit,
    onEdit: (CategoriaEntity) -> Unit
) {
    val state by viewModel.uiState.collectAsState()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = onCreate) {
                Icon(Icons.Default.Add, contentDescription = "Crear categoría")
            }
        }
    ) { padding ->
        when {
            state.isLoading -> {
                CircularProgressIndicator(
                    modifier = Modifier.padding(padding)
                )
            }

            state.error != null -> {
                Text(
                    text = state.error ?: "Error desconocido",
                    color = MaterialTheme.colorScheme.error,
                    modifier = Modifier.padding(padding)
                )
            }

            else -> {
                LazyColumn(
                    modifier = Modifier.padding(padding)
                ) {
                    items(state.categorias) { categoria ->
                        CategoriaCard(
                            categoria = categoria,
                            onEdit = onEdit,
                            onDelete = { id ->
                                viewModel.deleteCategoria(id)
                            }
                        )
                    }
                }
            }
        }
    }
}