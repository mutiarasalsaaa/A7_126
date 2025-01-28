//package com.example.uas.ui.viewmodel.Terapis
//
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.setValue
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.consumerestapi.model.Terapis
//import com.example.consumerestapi.repository.TerapisRepository
//import kotlinx.coroutines.launch
//
//class InsertTerapisViewModel(
//    private val terapisRepository: TerapisRepository
//) : ViewModel() {
//
//    var uiState by mutableStateOf(InsertUiState())
//        private set
//
//    fun updateInsertTerapisState(insertUiEvent: InsertUiEvent) {
//        uiState = InsertUiState(insertUiEvent = insertUiEvent)
//    }
//
//    suspend fun insertTerapis() {
//        viewModelScope.launch {
//            try {
//                terapisRepository.insertTerapis(uiState.insertUiEvent.toTerapis())
//            } catch (e: Exception) {
//                e.printStackTrace()
//            }
//        }
//    }
//}
//
//data class InsertUiState(
//    val insertUiEvent: InsertUiEvent = InsertUiEvent()
//)
//
//data class InsertUiEvent(
//    val id: String = "",
//    val nama: String = "",
//    val spesialisasi: String = ""
//)
//
//fun InsertUiEvent.toTerapis(): Terapis = Terapis(
//    id = id,
//    nama = nama,
//    spesialisasi = spesialisasi
//)
//
//fun Terapis.toUiStateTerapis(): InsertUiState = InsertUiState(
//    insertUiEvent = toInsertUiEvent()
//)
//
//fun Terapis.toInsertUiEvent(): InsertUiEvent = InsertUiEvent(
//    id = id,
//    nama = nama,
//    spesialisasi = spesialisasi
//)
