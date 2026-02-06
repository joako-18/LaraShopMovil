package com.esaudiaz.larashopmovil.core.network

import com.esaudiaz.larashopmovil.features.employee.data.datasources.remote.model.EmpleadoResponse
import com.esaudiaz.larashopmovil.features.employee.data.datasources.remote.model.EmpleadoCreateDto
import com.esaudiaz.larashopmovil.features.employee.data.datasources.remote.model.EmpleadoUpdateDto
import com.esaudiaz.larashopmovil.core.network.models.*
import retrofit2.http.*

interface AuthApi {
    @FormUrlEncoded
    @POST("auth/login")
    suspend fun login(
        @Field("username") username: String,
        @Field("password") password: String
    ): TokenResponse
}

interface EmpleadosApi {

    @GET("empleados/")
    suspend fun getAllEmpleados(
        @Query("skip") skip: Int = 0,
        @Query("limit") limit: Int = 100
    ): List<EmpleadoResponse>

    @GET("empleados/{empleado_id}")
    suspend fun getEmpleadoById(
        @Path("empleado_id") empleadoId: Int
    ): EmpleadoResponse

    @POST("empleados/")
    suspend fun createEmpleado(
        @Body empleado: EmpleadoCreateDto
    ): EmpleadoResponse

    @PUT("empleados/{empleado_id}")
    suspend fun updateEmpleado(
        @Path("empleado_id") empleadoId: Int,
        @Body empleado: EmpleadoUpdateDto
    ): EmpleadoResponse

    @DELETE("empleados/{empleado_id}")
    suspend fun deleteEmpleado(
        @Path("empleado_id") empleadoId: Int
    )
}

interface ProductosApi {

    @GET("productos/")
    suspend fun getAllProductos(
        @Query("skip") skip: Int = 0,
        @Query("limit") limit: Int = 100
    ): List<ProductoResponse>

    @GET("productos/{producto_id}")
    suspend fun getProductoById(
        @Path("producto_id") productoId: Int
    ): ProductoResponse

    @POST("productos/")
    suspend fun createProducto(
        @Body producto: ProductoCreateRequest
    ): ProductoResponse

    @PUT("productos/{producto_id}")
    suspend fun updateProducto(
        @Path("producto_id") productoId: Int,
        @Body producto: ProductoUpdateRequest
    ): ProductoResponse

    @DELETE("productos/{producto_id}")
    suspend fun deleteProducto(
        @Path("producto_id") productoId: Int
    )
}