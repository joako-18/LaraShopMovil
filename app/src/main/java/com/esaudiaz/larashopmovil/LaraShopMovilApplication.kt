package com.esaudiaz.larashopmovil

import android.app.Application
import com.esaudiaz.larashopmovil.core.di.AppContainer

class LaraShopMovilApplication : Application() {

    lateinit var appContainer: AppContainer

    override fun onCreate() {
        super.onCreate()
        appContainer = AppContainer(this)
    }
}