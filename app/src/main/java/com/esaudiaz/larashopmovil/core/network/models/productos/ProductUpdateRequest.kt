package com.esaudiaz.larashopmovil.core.network.models.productos

import com.google.gson.annotations.SerializedName

data class ProductoUpdateRequest(
    @SerializedName("nombre")
    val nombre: String? = null,
    @SerializedName("precio")
    val precio: String? = null,
    @SerializedName("stock")
    val stock: Int? = null,
    @SerializedName("stock_minimo")
    val stockMinimo: Int? = null,
    @SerializedName("id_categoria")
    val idCategoria: Int? = null,
    @SerializedName("id_proveedor")
    val idProveedor: Int? = null,
    @SerializedName("imagen")
    val imagen: String? = null,
    @SerializedName("estado")
    val estado: String? = null
)