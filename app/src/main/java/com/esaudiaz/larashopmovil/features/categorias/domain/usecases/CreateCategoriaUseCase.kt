package com.esaudiaz.larashopmovil.features.categorias.domain.usecases

import com.esaudiaz.larashopmovil.features.categorias.domain.entities.CategoriaEntity
import com.esaudiaz.larashopmovil.features.categorias.domain.repository.CategoriaRepository

class CreateCategoriaUseCase(
    private val repository: CategoriaRepository
){
    suspend operator fun invoke(
        nombre : String
    ): Result <CategoriaEntity>{
        return try {
            val categoria = repository.createCategoria(nombre)
            Result.success(categoria)
        }catch (e : Exception){
            Result.failure(e)
        }
    }
}