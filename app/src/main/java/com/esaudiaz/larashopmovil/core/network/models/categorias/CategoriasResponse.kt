package com.esaudiaz.larashopmovil.core.network.models.categorias
import com.google.gson.annotations.SerializedName

data class CategoriaResponse(
    @SerializedName("id_categoria")
    val id_categoria: Int,
    @SerializedName("nombre")
    val nombre: String
)
