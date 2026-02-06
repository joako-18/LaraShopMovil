package com.esaudiaz.larashopmovil.features.employee.domain.entities

data class Empleado(
    val id: Int,
    val nombre: String,
    val correo: String,
    val telefono: String?,
    val idTelegram: Long?,
    val rol: String,
    val estado: String,
    val fechaAlta: String
)

data class EmpleadoCreate(
    val nombre: String,
    val correo: String,
    val telefono: String? = null,
    val idTelegram: Long? = null,
    val rol: String,
    val estado: String = "activo",
    val contrasena: String
)

data class EmpleadoUpdate(
    val nombre: String? = null,
    val correo: String? = null,
    val telefono: String? = null,
    val idTelegram: Long? = null,
    val rol: String? = null,
    val estado: String? = null,
    val contrasena: String? = null
)