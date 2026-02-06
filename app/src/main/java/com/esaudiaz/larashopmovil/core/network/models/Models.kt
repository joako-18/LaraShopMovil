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



