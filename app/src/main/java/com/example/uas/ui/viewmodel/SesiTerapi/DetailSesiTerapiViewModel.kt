//package com.example.uas.ui.viewmodel.sesiTerapi
//
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.setValue
//import androidx.lifecycle.SavedStateHandle
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.uas.model.SesiTerapis
//import com.example.uas.ui.view.sesiTerapi.DestinasiDetailSesiTerapi
//import kotlinx.coroutines.launch
//import java.io.IOException
//
//sealed class DetailSesiTerapiUiState {
//    data class Success(val sesiTerapis: SesiTerapis) : DetailSesiTerapiUiState()
//    object Error : DetailSesiTerapiUiState()
//    object Loading : DetailSesiTerapiUiState()
//}
//
//class DetailSesiTerapiViewModel(
//    savedStateHandle: SavedStateHandle,
//    private val sesiTerapiRepository: SesiTerapiRepository
//) : ViewModel() {
//
//    private val id_sesi: String = checkNotNull(savedStateHandle[DestinasiDetailSesiTerapi.id_sesi])
//    var detailSesiTerapiUiState: DetailSesiTerapiUiState by mutableStateOf(DetailSesiTerapiUiState.Loading)
//        private set
//
//    init {
//        getSesiById()
//    }
//
//    fun getSesiById() {
//        viewModelScope.launch {
//            detailSesiTerapiUiState = DetailSesiTerapiUiState.Loading
//            detailSesiTerapiUiState = try {
//                DetailSesiTerapiUiState.Success(
//                    sesiTerapis = sesiTerapiRepository.getSesiByIdSesi(id_sesi)
//                )
//            } catch (e: IOException) {
//                DetailSesiTerapiUiState.Error
//            }
//        }
//    }
//}
//
//fun SesiTerapis.toDetailUiEvent(): InsertSesiTerapiEvent {
//    return InsertSesiTerapiEvent(
//        id_sesi = id_sesi,
//        id_pasien = id_pasien,
//        id_terapis = id_terapis,
//        tgl_sesi = tgl_sesi
//    )
//}
