package com.esaudiaz.larashopmovil.features.categorias.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.esaudiaz.larashopmovil.features.categorias.domain.entities.CategoriaEntity
import com.esaudiaz.larashopmovil.features.categorias.presentation.components.CategoriaCard
import com.esaudiaz.larashopmovil.features.categorias.presentation.viewmodels.CategoriaViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoriaFormScreen(
    categoria: CategoriaEntity?,
    onSave: (String) -> Unit,
    onCancel: () -> Unit
) {
    var nombre by remember {
        mutableStateOf(categoria?.nombre ?: "")
    }

    Column (modifier = Modifier.padding(16.dp)) {
        TextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre de la categoría") }
        )

        Spacer(Modifier.height(16.dp))

        Row {
            Button (onClick = { onSave(nombre) }) {
                Text("Guardar")
            }
            Spacer(Modifier.width(8.dp))
            OutlinedButton (onClick = onCancel) {
                Text("Cancelar")
            }
        }
    }
}
