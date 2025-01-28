//package com.example.uas.ui.viewmodel.Terapis
//
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.setValue
//import androidx.lifecycle.SavedStateHandle
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.consumerestapi.model.Terapis
//import com.example.consumerestapi.repository.TerapisRepository
//import com.example.consumerestapi.ui.screens.DestinasiDetail
//import kotlinx.coroutines.launch
//import java.io.IOException
//
//sealed class DetailTerapisUiState {
//    data class Success(val terapis: Terapis) : DetailTerapisUiState()
//    object Error : DetailTerapisUiState()
//    object Loading : DetailTerapisUiState()
//}
//
//class DetailTerapisViewModel(
//    savedStateHandle: SavedStateHandle,
//    private val terapisRepository: TerapisRepository
//) : ViewModel() {
//
//    private val id: String = checkNotNull(savedStateHandle[DestinasiDetail.id])
//    var detailTerapisUiState: DetailTerapisUiState by mutableStateOf(DetailTerapisUiState.Loading)
//        private set
//
//    init {
//        getTerapisById()
//    }
//
//    fun getTerapisById() {
//        viewModelScope.launch {
//            detailTerapisUiState = DetailTerapisUiState.Loading
//            detailTerapisUiState = try {
//                DetailTerapisUiState.Success(terapis = terapisRepository.getTerapisById(id))
//            } catch (e: IOException) {
//                DetailTerapisUiState.Error
//            }
//        }
//    }
//}
