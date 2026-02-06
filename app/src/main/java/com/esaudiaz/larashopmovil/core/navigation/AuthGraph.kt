package com.esaudiaz.larashopmovil.core.navigation


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable

fun NavGraphBuilder.authGraph(navController: NavHostController) {

    composable(Screen.Login.route) {
        LoginScreen(
            onLoginSuccess = {
                // Navegar al home y limpiar el back stack
                navController.navigate(Screen.Home.route) {
                    popUpTo(Screen.Login.route) { inclusive = true }
                }
            },
            onNavigateToRegister = {
                navController.navigate(Screen.Register.route)
            }
        )
    }

    composable(Screen.Register.route) {
        RegisterScreen(
            onRegisterSuccess = {
                navController.navigate(Screen.Home.route) {
                    popUpTo(Screen.Login.route) { inclusive = true }
                }
            },
            onNavigateBack = {
                navController.popBackStack()
            }
        )
    }
}

// Pantallas temporales (las reemplazarás con las reales)
@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit,
    onNavigateToRegister: () -> Unit
) {
    // TODO: Implementar pantalla de login real
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("PANTALLA DE LOGIN", style = MaterialTheme.typography.headlineMedium)

        Spacer(Modifier.height(16.dp))

        Button (onClick = onLoginSuccess) {
            Text("Simular Login Exitoso")
        }

        TextButton(onClick = onNavigateToRegister) {
            Text("Ir a Registro")
        }
    }
}

@Composable
fun RegisterScreen(
    onRegisterSuccess: () -> Unit,
    onNavigateBack: () -> Unit
) {
    // TODO: Implementar pantalla de registro real
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("PANTALLA DE REGISTRO", style = MaterialTheme.typography.headlineMedium)

        Spacer(Modifier.height(16.dp))

        Button(onClick = onRegisterSuccess) {
            Text("Simular Registro Exitoso")
        }

        TextButton (onClick = onNavigateBack) {
            Text("Volver al Login")
        }
    }
}