package com.esaudiaz.larashopmovil.core.network.models.categorias

import com.google.gson.annotations.SerializedName

data class CategoriaCreateUpdateRequest (
    @SerializedName("nombre")
    val nombre: String
)