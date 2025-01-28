package com.example.uas.ui.viewmodel.JenisTerapis

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.uas.Repository.JenisTerapisRepository
import com.example.uas.model.JenisTerapis
import com.example.uas.ui.view.JenisTerapis.DestinasiDetailJenisTerapis
import kotlinx.coroutines.launch
import java.io.IOException

sealed class DetailJnsUiState{
    data class Success(val jenisterapi: JenisTerapis) : DetailJnsUiState()
    object Error : DetailJnsUiState()
    object Loading : DetailJnsUiState()
}

class DetailJenisTerapisViewModel(
    savedStateHandle: SavedStateHandle,
    private val jenisterapiRepository: JenisTerapisRepository
) : ViewModel() {

    private val id_jenis_terapis: String = checkNotNull(savedStateHandle[DestinasiDetailJenisTerapis.id_jenis_terapis])
    var detailJnsUiState: DetailJnsUiState by mutableStateOf(DetailJnsUiState.Loading)
        private set

    init {
        getJnsById()
    }

    fun getJnsById(){
        viewModelScope.launch {
            detailJnsUiState = DetailJnsUiState.Loading
            detailJnsUiState = try {
                DetailJnsUiState.Success(jenisterapi = jenisterapiRepository.getJenisTerapisById(id_jenis_terapis))
            } catch (e: IOException) {
                DetailJnsUiState.Error
            }
        }
    }
}
