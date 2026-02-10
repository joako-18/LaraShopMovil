package com.esaudiaz.larashopmovil.core.network

sealed class NetworkResult<out T> {
    data class Success<T>(val data: T) : NetworkResult<T>()
    data class Error(val message: String, val code: Int? = null) : NetworkResult<Nothing>()
    object Loading : NetworkResult<Nothing>()
}

suspend fun <T> safeApiCall(
    apiCall: suspend () -> T
): NetworkResult<T> {
    return try {
        NetworkResult.Success(apiCall())
    } catch (e: retrofit2.HttpException) {
        when (e.code()) {
            401 -> NetworkResult.Error("No autorizado", 401)
            404 -> NetworkResult.Error("Recurso no encontrado", 404)
            409 -> NetworkResult.Error("Conflicto: El recurso ya existe o tiene dependencias", 409)
            else -> NetworkResult.Error(e.message() ?: "Error HTTP ${e.code()}", e.code())
        }
    } catch (e: java.net.UnknownHostException) {
        NetworkResult.Error("Sin conexión a internet")
    } catch (e: java.net.SocketTimeoutException) {
        NetworkResult.Error("Timeout: El servidor no respondió")
    } catch (e: Exception) {
        NetworkResult.Error(e.message ?: "Error desconocido")
    }
}