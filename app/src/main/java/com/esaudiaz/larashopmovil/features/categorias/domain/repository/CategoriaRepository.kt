package com.esaudiaz.larashopmovil.features.categorias.domain.repository

import com.esaudiaz.larashopmovil.features.categorias.domain.entities.CategoriaEntity

interface CategoriaRepository{
    suspend fun createCategoria(nombre: String): CategoriaEntity

    suspend fun getCategorias(): List <CategoriaEntity>

    suspend fun updateCategoria(categoriaEntity: CategoriaEntity) : CategoriaEntity

    suspend fun deleteCategoria(id: Int)
}