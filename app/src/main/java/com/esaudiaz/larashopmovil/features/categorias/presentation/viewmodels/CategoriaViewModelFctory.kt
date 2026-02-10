package com.esaudiaz.larashopmovil.features.categorias.presentation.viewmodels


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.esaudiaz.larashopmovil.features.categorias.domain.usecases.CreateCategoriaUseCase
import com.esaudiaz.larashopmovil.features.categorias.domain.usecases.DeleteCategoriaUseCase
import com.esaudiaz.larashopmovil.features.categorias.domain.usecases.GetCategoriasUseCase
import com.esaudiaz.larashopmovil.features.categorias.domain.usecases.UpdateCategoriaUseCase

class CategoriaViewModelFactory (
    private val getCategoriasUseCase: GetCategoriasUseCase,
    private val updateCategoriaUseCase: UpdateCategoriaUseCase,
    private val createCategoriaUseCase: CreateCategoriaUseCase,
    private val deleteCategoriaUseCase: DeleteCategoriaUseCase
): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(CategoriaViewModel::class.java)){
            return CategoriaViewModel(
                getCategoriasUseCase = getCategoriasUseCase,
                createCategoriaUseCase = createCategoriaUseCase,
                updateCategoriaUseCase = updateCategoriaUseCase,
                deleteCategoriaUseCase = deleteCategoriaUseCase
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}