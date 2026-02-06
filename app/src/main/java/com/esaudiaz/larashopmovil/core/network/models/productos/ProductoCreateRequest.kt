package com.esaudiaz.larashopmovil.core.network.models.productos

import com.google.gson.annotations.SerializedName

data class ProductoCreateRequest(
    @SerializedName("nombre")
    val nombre: String,
    @SerializedName("precio")
    val precio: String,  // Enviar como String "10.50"
    @SerializedName("stock")
    val stock: Int = 0,
    @SerializedName("stock_minimo")
    val stockMinimo: Int = 0,
    @SerializedName("id_categoria")
    val idCategoria: Int,
    @SerializedName("id_proveedor")
    val idProveedor: Int,
    @SerializedName("imagen")
    val imagen: String? = null,
    @SerializedName("estado")
    val estado: String = "activo"
)