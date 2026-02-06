package com.esaudiaz.larashopmovil.features.employee.data.datasources.remote.model

import com.google.gson.annotations.SerializedName

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
    val rol: String,
    @SerializedName("estado")
    val estado: String,
    @SerializedName("fecha_alta")
    val fechaAlta: String
)

data class EmpleadoCreateDto(
    @SerializedName("nombre")
    val nombre: String,
    @SerializedName("correo")
    val correo: String,
    @SerializedName("telefono")
    val telefono: String?,
    @SerializedName("id_telegram")
    val idTelegram: Long?,
    @SerializedName("rol")
    val rol: String,
    @SerializedName("estado")
    val estado: String,
    @SerializedName("contrasena")
    val contrasena: String
)

data class EmpleadoUpdateDto(
    @SerializedName("nombre")
    val nombre: String?,
    @SerializedName("correo")
    val correo: String?,
    @SerializedName("telefono")
    val telefono: String?,
    @SerializedName("id_telegram")
    val idTelegram: Long?,
    @SerializedName("rol")
    val rol: String?,
    @SerializedName("estado")
    val estado: String?,
    @SerializedName("contrasena")
    val contrasena: String?
)