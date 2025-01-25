package com.example.uas.ui.viewmodel.JenisTerapis

import com.example.uas.Repository.JenisTerapisRepository
import com.example.uas.model.JenisTerapis
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

sealed class DetailJenisTerapisUiState {
    object Loading : DetailJenisTerapisUiState()
    data class Success(val jenisTerapis: JenisTerapis) : DetailJenisTerapisUiState()
    data class Error(val message: String) : DetailJenisTerapisUiState()
}

class DetailJenisTerapisViewModel(
    private val repository: JenisTerapisRepository,
    private val idJenis: String
) : ViewModel() {

    private val _detailJenisTerapisUiState = MutableStateFlow<DetailJenisTerapisUiState>(DetailJenisTerapisUiState.Loading)
    val detailJenisTerapisUiState: StateFlow<DetailJenisTerapisUiState> = _detailJenisTerapisUiState

    init {
        getJenisTerapisById()
    }

    fun getJenisTerapisById() {
        viewModelScope.launch {
            _detailJenisTerapisUiState.value = DetailJenisTerapisUiState.Loading
            try {
                val jenisTerapis = repository.getJenisTerapisById(idJenis)
                _detailJenisTerapisUiState.value = DetailJenisTerapisUiState.Success(jenisTerapis)
            } catch (e: Exception) {
                _detailJenisTerapisUiState.value = DetailJenisTerapisUiState.Error("Terjadi kesalahan: ${e.message}")
            }
        }
    }

    companion object {
        fun provideFactory(
            repository: JenisTerapisRepository,
            idJenis: String
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                if (modelClass.isAssignableFrom(DetailJenisTerapisViewModel::class.java)) {
                    return DetailJenisTerapisViewModel(repository, idJenis) as T
                }
                throw IllegalArgumentException("Unknown ViewModel class")
            }
        }
    }
}
