package com.esaudiaz.larashopmovil.core.network.models

import com.google.gson.annotations.SerializedName

// ============ AUTH MODELS ============
data class TokenResponse(
    @SerializedName("access_token")
    val accessToken: String,
    @SerializedName("token_type")
    val tokenType: String
)

// ============ EMPLEADO MODELS ============
data class EmpleadoResponse(
    @SerializedName("id_empleado")
    val idEmpleado: Int,
    @SerializedName("nombre")
    val nombre: String,
    @SerializedName("correo")
    val correo: String,
    @SerializedName("telefono")
    val telefono: String?,
    @SerializedName("id_telegram")
    val idTelegram: Long?,
    @SerializedName("rol")
    val rol: String,  // "administrador" o "empleado"
    @SerializedName("estado")
    val estado: String,  // "activo" o "inactivo"
    @SerializedName("fecha_alta")
    val fechaAlta: String
)

data class EmpleadoCreateRequest(
    @SerializedName("nombre")
    val nombre: String,
    @SerializedName("correo")
    val correo: String,
    @SerializedName("telefono")
    val telefono: String? = null,
    @SerializedName("id_telegram")
    val idTelegram: Long? = null,
    @SerializedName("rol")
    val rol: String,  // "administrador" o "empleado"
    @SerializedName("estado")
    val estado: String = "activo",
    @SerializedName("contrasena")
    val contrasena: String
)

data class EmpleadoUpdateRequest(
    @SerializedName("nombre")
    val nombre: String? = null,
    @SerializedName("correo")
    val correo: String? = null,
    @SerializedName("telefono")
    val telefono: String? = null,
    @SerializedName("id_telegram")
    val idTelegram: Long? = null,
    @SerializedName("rol")
    val rol: String? = null,
    @SerializedName("estado")
    val estado: String? = null,
    @SerializedName("contrasena")
    val contrasena: String? = null
)

// ============ PRODUCTO MODELS ============
data class CategoriaSimple(
    @SerializedName("id_categoria")
    val idCategoria: Int,
    @SerializedName("nombre")
    val nombre: String
)

data class ProveedorSimple(
    @SerializedName("id_proveedor")
    val idProveedor: Int,
    @SerializedName("nombre")
    val nombre: String
)

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
    val categoria: CategoriaSimple,
    @SerializedName("proveedor")
    val proveedor: ProveedorSimple
)

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