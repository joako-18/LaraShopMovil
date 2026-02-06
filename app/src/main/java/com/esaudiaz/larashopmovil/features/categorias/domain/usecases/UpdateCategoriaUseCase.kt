package com.esaudiaz.larashopmovil.features.categorias.domain.usecases

import com.esaudiaz.larashopmovil.features.categorias.domain.entities.CategoriaEntity
import com.esaudiaz.larashopmovil.features.categorias.domain.repository.CategoriaRepository

class UpdateCategoriaUseCase(
    private val repository: CategoriaRepository
){
    suspend operator fun invoke(
        categoria : CategoriaEntity
    ): Result <CategoriaEntity>{
        return try {
            val updated = repository.updateCategoria(categoria)
            Result.success(updated)
        }catch (e: Exception){
            Result.failure(e)
        }
    }
}