package com.esaudiaz.larashopmovil.core.navigation

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Register : Screen("register")
    object Home : Screen("home")
    object Categorias : Screen("categorias")
    object CrearCategoria : Screen("categorias/crear")
    object EditarCategoria : Screen("categorias/editar/{categoriaId}") {
        fun createRoute(categoriaId: Int) = "categorias/editar/$categoriaId"
    }
    object Empleados : Screen("empleados")
}