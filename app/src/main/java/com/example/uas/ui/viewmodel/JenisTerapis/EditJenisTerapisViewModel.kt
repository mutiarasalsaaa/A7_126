package com.example.finalpam.ui.viewmodel.jenisTerapi

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalpam.ui.viewmodel.jenis_terapis.InsertJenisTerapisUiEvent
import com.example.finalpam.ui.viewmodel.jenis_terapis.InsertJenisTerapisUiState
import com.example.finalpam.ui.viewmodel.jenis_terapis.toJns
import com.example.finalpam.ui.viewmodel.jenis_terapis.toUiStateJns
import com.example.uas.Repository.JenisTerapisRepository
import com.example.uas.ui.view.JenisTerapis.DestinasiEditJenisTerapis
import kotlinx.coroutines.launch

class EditJenisTerapisViewModel(
    savedStateHandle: SavedStateHandle,
    private val jenisTerapiRepository: JenisTerapisRepository
) : ViewModel() {

    var uiState by mutableStateOf(InsertJenisTerapisUiState())
        private set

    val id_jenis_terapis: String = checkNotNull(savedStateHandle[DestinasiEditJenisTerapis.id_jenis_terapis])

    init {
        viewModelScope.launch {
            uiState = jenisTerapiRepository.getJenisTerapisById(id_jenis_terapis).toUiStateJns()
        }
    }

    fun updateInsertJnsState(insertJenisTerapisUiEvent: InsertJenisTerapisUiEvent) {
        uiState = InsertJenisTerapisUiState(insertJenisTerapisUiEvent = insertJenisTerapisUiEvent)
    }

    suspend fun editJenisTerapis(){
        viewModelScope.launch {
            try {
                jenisTerapiRepository.updateJenisTerapis(id_jenis_terapis, uiState.insertJenisTerapisUiEvent.toJns())
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}