package com.esaudiaz.larashopmovil

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import com.esaudiaz.larashopmovil.core.di.AppContainer
import com.esaudiaz.larashopmovil.core.ui.theme.LaraShopMovilTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private lateinit var appContainer: AppContainer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        appContainer = (application as LaraShopMovilApplication).appContainer

        testApiConnection()

        setContent {
            LaraShopMovilTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    private fun testApiConnection() {
        lifecycleScope.launch {
            try {
                Log.d("API_TEST", "🔄 Iniciando prueba de conexión...")

                // Test 1: Obtener todos los productos
                val productos = appContainer.productosApi.getAllProductos()
                Log.d("API_TEST", "✅ Productos obtenidos: ${productos.size}")
                productos.forEach { producto ->
                    Log.d("API_TEST", "  📦 ${producto.nombre} - $${producto.precio}")
                }

                // Test 2: Obtener todos los empleados
                val empleados = appContainer.empleadosApi.getAllEmpleados()
                Log.d("API_TEST", "✅ Empleados obtenidos: ${empleados.size}")
                empleados.forEach { empleado ->
                    Log.d("API_TEST", "  👤 ${empleado.nombre} - ${empleado.correo}")
                }

                Log.d("API_TEST", "🎉 ¡Conexión exitosa a la API!")

            } catch (e: Exception) {
                Log.e("API_TEST", "❌ Error al conectar con la API: ${e.message}")
                Log.e("API_TEST", "Stack trace:", e)
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}