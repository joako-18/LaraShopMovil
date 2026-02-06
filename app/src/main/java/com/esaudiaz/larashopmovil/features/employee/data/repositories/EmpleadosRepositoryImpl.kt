package com.esaudiaz.larashopmovil.features.employee.data.repositories

import com.esaudiaz.larashopmovil.core.network.EmpleadosApi
import com.esaudiaz.larashopmovil.features.employee.data.datasources.remote.mapper.toDomain
import com.esaudiaz.larashopmovil.features.employee.data.datasources.remote.mapper.toDto
import com.esaudiaz.larashopmovil.features.employee.domain.entities.Empleado
import com.esaudiaz.larashopmovil.features.employee.domain.entities.EmpleadoCreate
import com.esaudiaz.larashopmovil.features.employee.domain.entities.EmpleadoUpdate
import com.esaudiaz.larashopmovil.features.employee.domain.repositories.EmpleadosRepository

class EmpleadosRepositoryImpl(
    private val api: EmpleadosApi
) : EmpleadosRepository {

    override suspend fun getAllEmpleados(skip: Int, limit: Int): List<Empleado> {
        val response = api.getAllEmpleados(skip, limit)
        return response.map { it.toDomain() }
    }

    override suspend fun getEmpleadoById(id: Int): Empleado {
        val response = api.getEmpleadoById(id)
        return response.toDomain()
    }

    override suspend fun createEmpleado(empleado: EmpleadoCreate): Empleado {
        val response = api.createEmpleado(empleado.toDto())
        return response.toDomain()
    }

    override suspend fun updateEmpleado(id: Int, empleado: EmpleadoUpdate): Empleado {
        val response = api.updateEmpleado(id, empleado.toDto())
        return response.toDomain()
    }

    override suspend fun deleteEmpleado(id: Int) {
        api.deleteEmpleado(id)
    }
}