package com.esaudiaz.larashopmovil.features.categorias.domain.usecases

import com.esaudiaz.larashopmovil.features.categorias.domain.entities.CategoriaEntity
import com.esaudiaz.larashopmovil.features.categorias.domain.repository.CategoriaRepository

class GetCategoriasUseCase(
    private val repository : CategoriaRepository
){
    suspend operator fun invoke(): Result <List<CategoriaEntity>>{
        return try {
            val categorias = repository.getCategorias()
            Result.success(categorias)
        }catch (e: Exception){
            Result.failure(e)
        }
    }
}