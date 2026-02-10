package com.esaudiaz.larashopmovil.core.network.models.productos

import com.google.gson.annotations.SerializedName

data class ProveedorSimple(
    @SerializedName("id_proveedor")
    val idProveedor: Int,
    @SerializedName("nombre")
    val nombre: String
)
