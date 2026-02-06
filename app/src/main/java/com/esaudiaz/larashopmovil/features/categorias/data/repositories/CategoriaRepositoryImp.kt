package com.esaudiaz.larashopmovil.features.categorias.data.repositories

import android.util.Log
import com.esaudiaz.larashopmovil.core.network.CategoriasApi
import com.esaudiaz.larashopmovil.core.network.models.categorias.CategoriaCreateUpdateRequest
import com.esaudiaz.larashopmovil.features.categorias.domain.entities.CategoriaEntity
import com.esaudiaz.larashopmovil.features.categorias.domain.repository.CategoriaRepository

class CategoriaRepositoryImp (
    private val api: CategoriasApi
): CategoriaRepository{
    override suspend fun getCategorias(): List<CategoriaEntity> {
        return api.getAllCategories().map{
            CategoriaEntity(
                id_categoria = it.id_categoria,
                nombre = it.nombre
            )
        }
    }
    override suspend fun createCategoria(nombre: String): CategoriaEntity {
        val response = api.createCategoria(
            CategoriaCreateUpdateRequest(nombre)
        )
        return CategoriaEntity(response.id_categoria, response.nombre)
    }

    override suspend fun updateCategoria(categoria: CategoriaEntity): CategoriaEntity {
        val response = api.updateCategoria(
            categoriaId = categoria.id_categoria,
            categoria = CategoriaCreateUpdateRequest(categoria.nombre)
        )
        return CategoriaEntity(response.id_categoria, response.nombre)
    }

    override suspend fun deleteCategoria(id: Int) {
        api.deleteCategoria(id)
    }
}