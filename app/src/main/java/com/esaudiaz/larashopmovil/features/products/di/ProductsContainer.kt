/*
package com.esaudiaz.larashopmovil.features.products.di

import com.esaudiaz.larashopmovil.core.network.ProductosApi
import com.esaudiaz.larashopmovil.features.products.data.repositories.ProductsRepository
import com.esaudiaz.larashopmovil.features.products.domain.usecases.GetProductsUseCase

class ProductsContainer(
    productosApi: ProductosApi
) {

    val productsRepository: ProductsRepository by lazy {
        ProductsRepository(productosApi)
    }

    val getProductsUseCase: GetProductsUseCase by lazy {
        GetProductsUseCase(productsRepository)
    }
}
*/
