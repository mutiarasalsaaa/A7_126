//package com.example.uas.ui.viewmodel.SesiTerapi
//
//package com.example.consumerestapi.ui.viewmodel
//
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.setValue
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.consumerestapi.model.SesiTerapis
//import com.example.consumerestapi.repository.SesiTerapisRepository
//import kotlinx.coroutines.launch
//
//class InsertSesiTerapisViewModel(
//    private val sesiTerapisRepository: SesiTerapisRepository
//) : ViewModel() {
//
//    var uiState by mutableStateOf(InsertUiState())
//        private set
//
//    fun updateInsertSesiTerapisState(insertUiEvent: InsertUiEvent) {
//        uiState = InsertUiState(insertUiEvent = insertUiEvent)
//    }
//
//    suspend fun insertSesiTerapis() {
//        viewModelScope.launch {
//            try {
//                sesiTerapisRepository.insertSesiTerapis(uiState.insertUiEvent.toSesiTerapis())
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
//    val jenisTerapisId: String = "",
//    val pasienId: String = "",
//    val jadwal: String = ""
//)
//
//fun InsertUiEvent.toSesiTerapis(): SesiTerapis = SesiTerapis(
//    id = id,
//    jenisTerapisId = jenisTerapisId,
//    pasienId = pasienId,
//    jadwal = jadwal
//)
//
//fun SesiTerapis.toUiStateSesiTerapis(): InsertUiState = InsertUiState(
//    insertUiEvent = toInsertUiEvent()
//)
//
//fun SesiTerapis.toInsertUiEvent(): InsertUiEvent = InsertUiEvent(
//    id = id,
//    jenisTerapisId = jenisTerapisId,
//    pasienId = pasienId,
//    jadwal = jadwal
//)
