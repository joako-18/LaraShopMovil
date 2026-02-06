package com.esaudiaz.larashopmovil.features.employee.domain.usecases

import android.util.Patterns
import com.esaudiaz.larashopmovil.features.employee.domain.entities.Empleado
import com.esaudiaz.larashopmovil.features.employee.domain.entities.EmpleadoCreate
import com.esaudiaz.larashopmovil.features.employee.domain.entities.EmpleadoUpdate
import com.esaudiaz.larashopmovil.features.employee.domain.repositories.EmpleadosRepository

class GetAllEmpleadosUseCase(
    private val repository: EmpleadosRepository
) {
    suspend operator fun invoke(): Result<List<Empleado>> {
        return try {
            val empleados = repository.getAllEmpleados()
            Result.success(empleados)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}

class CreateEmpleadoUseCase(
    private val repository: EmpleadosRepository
) {
    suspend operator fun invoke(empleado: EmpleadoCreate): Result<Empleado> {
        return try {
            // Validaciones
            if (empleado.nombre.isBlank()) {
                return Result.failure(Exception("El nombre no puede estar vacío"))
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(empleado.correo).matches()) {
                return Result.failure(Exception("El correo no es válido"))
            }

            if (empleado.contrasena.length < 8) {
                return Result.failure(Exception("La contraseña debe tener al menos 8 caracteres"))
            }

            val nuevoEmpleado = repository.createEmpleado(empleado)
            Result.success(nuevoEmpleado)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}

class UpdateEmpleadoUseCase(
    private val repository: EmpleadosRepository
) {
    suspend operator fun invoke(id: Int, empleado: EmpleadoUpdate): Result<Empleado> {
        return try {
            // Validar email si se está actualizando
            if (empleado.correo != null && !Patterns.EMAIL_ADDRESS.matcher(empleado.correo).matches()) {
                return Result.failure(Exception("El correo no es válido"))
            }

            // Validar contraseña si se está actualizando
            if (empleado.contrasena != null && empleado.contrasena.length < 8) {
                return Result.failure(Exception("La contraseña debe tener al menos 8 caracteres"))
            }

            val empleadoActualizado = repository.updateEmpleado(id, empleado)
            Result.success(empleadoActualizado)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}

class DeleteEmpleadoUseCase(
    private val repository: EmpleadosRepository
) {
    suspend operator fun invoke(id: Int): Result<Unit> {
        return try {
            repository.deleteEmpleado(id)
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}