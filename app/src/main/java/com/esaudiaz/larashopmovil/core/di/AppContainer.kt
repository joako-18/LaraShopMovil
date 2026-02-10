package com.esaudiaz.larashopmovil.core.di

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.esaudiaz.larashopmovil.core.auth.TokenManager
import com.esaudiaz.larashopmovil.core.network.AuthApi
import com.esaudiaz.larashopmovil.core.network.AuthInterceptor
import com.esaudiaz.larashopmovil.core.network.CategoriasApi
import com.esaudiaz.larashopmovil.core.network.EmpleadosApi
import com.esaudiaz.larashopmovil.core.network.NetworkConfig
import com.esaudiaz.larashopmovil.core.network.ProductosApi
import com.esaudiaz.larashopmovil.features.categorias.domain.repository.CategoriaRepository
import com.esaudiaz.larashopmovil.features.employee.data.repositories.EmpleadosRepositoryImpl
import com.esaudiaz.larashopmovil.features.employee.domain.repositories.EmpleadosRepository
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class AppContainer(context: Context) {

    val tokenManager = TokenManager(context)

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val retryInterceptor = Interceptor { chain ->
        var request = chain.request()
        var response = chain.proceed(request)
        var tryCount = 0
        val maxRetries = 3

        while (!response.isSuccessful && tryCount < maxRetries) {
            tryCount++
            response.close()
            Thread.sleep((1000 * tryCount * 2).toLong())
            response = chain.proceed(request)
        }

        response
    }

    private val authInterceptor = AuthInterceptor { tokenManager.getToken() }

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(retryInterceptor)
        .addInterceptor(authInterceptor)
        .addInterceptor(loggingInterceptor)
        .connectTimeout(NetworkConfig.CONNECT_TIMEOUT, TimeUnit.SECONDS)
        .readTimeout(NetworkConfig.READ_TIMEOUT, TimeUnit.SECONDS)
        .writeTimeout(NetworkConfig.WRITE_TIMEOUT, TimeUnit.SECONDS)
        .build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(NetworkConfig.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val authApi: AuthApi by lazy {
        retrofit.create(AuthApi::class.java)
    }

    val empleadosApi: EmpleadosApi by lazy {
        retrofit.create(EmpleadosApi::class.java)
    }

    val categoriasApi: CategoriasApi by lazy{
        retrofit.create(CategoriasApi::class.java)
    }
    val productosApi: ProductosApi by lazy {
        retrofit.create(ProductosApi::class.java)
    }

    val empleadosRepository: EmpleadosRepository by lazy {
        EmpleadosRepositoryImpl(empleadosApi)
    }
}