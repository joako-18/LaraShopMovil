package com.esaudiaz.larashopmovil.features.employee.domain.repositories

import com.esaudiaz.larashopmovil.features.employee.domain.entities.Empleado
import com.esaudiaz.larashopmovil.features.employee.domain.entities.EmpleadoCreate
import com.esaudiaz.larashopmovil.features.employee.domain.entities.EmpleadoUpdate

interface EmpleadosRepository {
    suspend fun getAllEmpleados(skip: Int = 0, limit: Int = 100): List<Empleado>
    suspend fun getEmpleadoById(id: Int): Empleado
    suspend fun createEmpleado(empleado: EmpleadoCreate): Empleado
    suspend fun updateEmpleado(id: Int, empleado: EmpleadoUpdate): Empleado
    suspend fun deleteEmpleado(id: Int)
}