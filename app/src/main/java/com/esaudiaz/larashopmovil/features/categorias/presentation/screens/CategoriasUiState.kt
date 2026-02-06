package com.esaudiaz.larashopmovil.features.categorias.presentation.screens

import com.esaudiaz.larashopmovil.features.categorias.domain.entities.CategoriaEntity

data class CategoriasUiState(
    val isLoading: Boolean = false,

    val categorias: List <CategoriaEntity> = emptyList(),

    val error: String? = null,

    val isRefreshing: Boolean = false
)