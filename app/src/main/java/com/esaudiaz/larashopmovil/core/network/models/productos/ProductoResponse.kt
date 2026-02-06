package com.esaudiaz.larashopmovil.core.network.models.productos

import com.esaudiaz.larashopmovil.core.network.models.categorias.CategoriaResponse
import com.google.gson.annotations.SerializedName

data class ProductoResponse(
    @SerializedName("id_producto")
    val idProducto: Int,
    @SerializedName("nombre")
    val nombre: String,
    @SerializedName("precio")
    val precio: String,  // Decimal viene como String
    @SerializedName("stock")
    val stock: Int,
    @SerializedName("stock_minimo")
    val stockMinimo: Int,
    @SerializedName("id_categoria")
    val idCategoria: Int,
    @SerializedName("id_proveedor")
    val idProveedor: Int,
    @SerializedName("imagen")
    val imagen: String?,
    @SerializedName("estado")
    val estado: String,  // "activo" o "inactivo"
    @SerializedName("categoria")
    val categoria: CategoriaResponse,
    @SerializedName("proveedor")
    val proveedor: ProveedorSimple
)