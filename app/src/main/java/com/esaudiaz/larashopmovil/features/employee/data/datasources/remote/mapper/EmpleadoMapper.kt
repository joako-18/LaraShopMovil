package com.esaudiaz.larashopmovil.features.employee.data.datasources.remote.mapper

import com.esaudiaz.larashopmovil.features.employee.data.datasources.remote.model.EmpleadoCreateDto
import com.esaudiaz.larashopmovil.features.employee.data.datasources.remote.model.EmpleadoResponse
import com.esaudiaz.larashopmovil.features.employee.data.datasources.remote.model.EmpleadoUpdateDto
import com.esaudiaz.larashopmovil.features.employee.domain.entities.Empleado
import com.esaudiaz.larashopmovil.features.employee.domain.entities.EmpleadoCreate
import com.esaudiaz.larashopmovil.features.employee.domain.entities.EmpleadoUpdate

fun EmpleadoResponse.toDomain(): Empleado {
    return Empleado(
        id = this.idEmpleado,
        nombre = this.nombre,
        correo = this.correo,
        telefono = this.telefono,
        idTelegram = this.idTelegram,
        rol = this.rol,
        estado = this.estado,
        fechaAlta = this.fechaAlta
    )
}

fun EmpleadoCreate.toDto(): EmpleadoCreateDto {
    return EmpleadoCreateDto(
        nombre = this.nombre,
        correo = this.correo,
        telefono = this.telefono,
        idTelegram = this.idTelegram,
        rol = this.rol,
        estado = this.estado,
        contrasena = this.contrasena
    )
}

fun EmpleadoUpdate.toDto(): EmpleadoUpdateDto {
    return EmpleadoUpdateDto(
        nombre = this.nombre,
        correo = this.correo,
        telefono = this.telefono,
        idTelegram = this.idTelegram,
        rol = this.rol,
        estado = this.estado,
        contrasena = this.contrasena
    )
}