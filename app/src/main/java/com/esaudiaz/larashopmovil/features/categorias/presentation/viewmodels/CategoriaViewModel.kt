package com.esaudiaz.larashopmovil.features.categorias.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.esaudiaz.larashopmovil.features.categorias.domain.entities.CategoriaEntity

import com.esaudiaz.larashopmovil.features.categorias.domain.usecases.CreateCategoriaUseCase
import com.esaudiaz.larashopmovil.features.categorias.domain.usecases.GetCategoriasUseCase
import com.esaudiaz.larashopmovil.features.categorias.domain.usecases.UpdateCategoriaUseCase
import com.esaudiaz.larashopmovil.features.categorias.domain.usecases.DeleteCategoriaUseCase
import com.esaudiaz.larashopmovil.features.categorias.presentation.screens.CategoriasUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CategoriaViewModel (
    private val getCategoriasUseCase: GetCategoriasUseCase,
    private val createCategoriaUseCase: CreateCategoriaUseCase,
    private val updateCategoriaUseCase: UpdateCategoriaUseCase,
    private val deleteCategoriaUseCase: DeleteCategoriaUseCase,
): ViewModel(){
    private val _uiState = MutableStateFlow(CategoriasUiState())

    val uiState = _uiState.asStateFlow()

    init {
        getCategorias()
    }

    private fun getCategorias(){
        _uiState.update { it.copy(isLoading = true) }

        viewModelScope.launch {
            val result = getCategoriasUseCase()

            _uiState.update { currentState ->
                result.fold(
                    onSuccess = {list ->
                        currentState.copy(isLoading = false, categorias = list)
                    }, onFailure = { error ->
                        currentState.copy(isLoading = false, error = error.message)
                    }
                )
            }
        }
    }

    fun createCategoria(nombre: String){
        viewModelScope.launch {
            val result = createCategoriaUseCase(nombre)
            result.fold(
                onSuccess = { categoria ->
                    _uiState.update {
                        it.copy(
                            categorias = it.categorias + categoria,
                            error = null
                        )
                    }
                }, onFailure = { error ->
                    _uiState.update { it.copy(error = error.message) }
                }
            )
        }
    }

    fun updateCategoria(categoria: CategoriaEntity) {
        viewModelScope.launch {
            val result = updateCategoriaUseCase(categoria)

            result.fold(
                onSuccess = { updated ->
                    _uiState.update {
                        it.copy(
                            categorias = it.categorias.map {
                                if (it.id_categoria == updated.id_categoria) updated else it
                            },
                            error = null
                        )
                    }
                },
                onFailure = { error ->
                    _uiState.update { it.copy(error = error.message) }
                }
            )
        }
    }


    fun deleteCategoria(id: Int) {
        viewModelScope.launch {
            val result = deleteCategoriaUseCase(id)

            result.fold(
                onSuccess = {
                    _uiState.update {
                        it.copy(
                            categorias = it.categorias.filterNot { it.id_categoria == id },
                            error = null
                        )
                    }
                },
                onFailure = { error ->
                    _uiState.update { it.copy(error = error.message) }
                }
            )
        }
    }

}
