package com.esaudiaz.larashopmovil

import android.app.Application
import com.esaudiaz.larashopmovil.core.di.AppContainer
import com.esaudiaz.larashopmovil.features.categorias.di.CategoriasContainer

class LaraShopMovilApplication : Application() {

    lateinit var appContainer: AppContainer
    lateinit var categoriasContainer: CategoriasContainer

    override fun onCreate() {
        super.onCreate()
        appContainer = AppContainer(this)
        categoriasContainer = CategoriasContainer(appContainer)
    }
}