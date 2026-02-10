package com.esaudiaz.larashopmovil.features.categorias.domain.usecases

import com.esaudiaz.larashopmovil.features.categorias.domain.repository.CategoriaRepository

class DeleteCategoriaUseCase (
    private val repository: CategoriaRepository
){
    suspend operator fun invoke(id: Int): Result <Unit>{
        return try {
            repository.deleteCategoria(id)
            Result.success(Unit)
        }catch (e : Exception){
            Result.failure(e)
        }
    }
}