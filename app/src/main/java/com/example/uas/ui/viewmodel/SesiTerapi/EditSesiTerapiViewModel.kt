//package com.example.uas.ui.viewmodel.SesiTerapi
//
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.setValue
//import androidx.lifecycle.SavedStateHandle
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.uas.Repository.SesiTerapisRepository
//import kotlinx.coroutines.launch
//
//class EditSesiTerapisViewModel(
//    savedStateHandle: SavedStateHandle,
//    private val sesiTerapisRepository: SesiTerapisRepository
//) : ViewModel() {
//
//    var uiState by mutableStateOf(InsertUiState())
//        private set
//
//    private val id: String = checkNotNull(savedStateHandle[DestinasiEdit.id])
//
//    init {
//        viewModelScope.launch {
//            uiState = sesiTerapisRepository.getSesiTerapisById(id).toUiStateSesiTerapis()
//        }
//    }
//
//    fun updateInsertSesiTerapisState(insertUiEvent: InsertUiEvent) {
//        uiState = InsertUiState(insertUiEvent = insertUiEvent)
//    }
//
//    suspend fun editSesiTerapis() {
//        viewModelScope.launch {
//            try {
//                sesiTerapisRepository.updateSesiTerapis(id, uiState.insertUiEvent.toSesiTerapis())
//            } catch (e: Exception) {
//                e.printStackTrace()
//            }
//        }
//    }
//}
