package com.esaudiaz.larashopmovil.features.login.domain.usecases

import android.util.Patterns
import com.esaudiaz.larashopmovil.features.login.domain.entities.AuthToken
import com.esaudiaz.larashopmovil.features.login.domain.repositories.AuthRepository

class LoginUseCase(
    private val repository: AuthRepository
) {

    suspend operator fun invoke(email: String, password: String): Result<AuthToken> {
        return try {
            // Validar email vacío
            if (email.isBlank()) {
                return Result.failure(Exception("El correo no puede estar vacío"))
            }

            // Validar formato de email
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                return Result.failure(Exception("El correo no es válido"))
            }

            // Validar contraseña vacía
            if (password.isBlank()) {
                return Result.failure(Exception("La contraseña no puede estar vacía"))
            }

            // Validar longitud mínima de contraseña
            if (password.length < 8) {
                return Result.failure(Exception("La contraseña debe tener al menos 8 caracteres"))
            }

            // Ejecutar login
            val authToken = repository.login(email, password)
            Result.success(authToken)

        } catch (e: retrofit2.HttpException) {
            when (e.code()) {
                401 -> Result.failure(Exception("Correo o contraseña incorrectos"))
                else -> Result.failure(Exception("Error al iniciar sesión: ${e.message()}"))
            }
        } catch (e: Exception) {
            Result.failure(Exception("Error: ${e.message ?: "Desconocido"}"))
        }
    }
}