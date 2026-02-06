
package com.esaudiaz.larashopmovil.features.categorias.di

import com.esaudiaz.larashopmovil.core.di.AppContainer
import com.esaudiaz.larashopmovil.features.categorias.presentation.viewmodels.CategoriaViewModelFactory
import com.esaudiaz.larashopmovil.features.categorias.domain.repository.CategoriaRepository
import com.esaudiaz.larashopmovil.features.categorias.domain.usecases.GetCategoriasUseCase
import com.esaudiaz.larashopmovil.features.categorias.domain.usecases.CreateCategoriaUseCase
import com.esaudiaz.larashopmovil.features.categorias.domain.usecases.UpdateCategoriaUseCase
import com.esaudiaz.larashopmovil.features.categorias.domain.usecases.DeleteCategoriaUseCase
import com.esaudiaz.larashopmovil.features.categorias.data.repositories.CategoriaRepositoryImp


class CategoriasContainer(
    appContainer: AppContainer
) {

    // 🔹 Repository
    private val categoriaRepository: CategoriaRepository =
        CategoriaRepositoryImp(appContainer.categoriasApi)

    // 🔹 UseCases
    val getCategoriasUseCase = GetCategoriasUseCase(categoriaRepository)

    val createCategoriaUseCase = CreateCategoriaUseCase(categoriaRepository)

    val updateCategoriaUseCase = UpdateCategoriaUseCase(categoriaRepository)

    val deleteCategoriaUseCase = DeleteCategoriaUseCase(categoriaRepository)

    // 🔹 ViewModel Factory
    val categoriaViewModelFactory = CategoriaViewModelFactory(
        getCategoriasUseCase = getCategoriasUseCase,
        createCategoriaUseCase = createCategoriaUseCase,
        updateCategoriaUseCase = updateCategoriaUseCase,
        deleteCategoriaUseCase = deleteCategoriaUseCase
    )
}
