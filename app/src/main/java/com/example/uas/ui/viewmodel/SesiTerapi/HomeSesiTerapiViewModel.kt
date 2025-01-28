//package com.example.uas.ui.viewmodel.SesiTerapi
//
//package com.example.consumerestapi.ui.viewmodel
//
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.setValue
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import coil.network.HttpException
//import com.example.consumerestapi.model.SesiTerapis
//import com.example.consumerestapi.repository.SesiTerapisRepository
//import kotlinx.coroutines.launch
//import java.io.IOException
//
//sealed class HomeSesiTerapisUiState {
//    data class Success(val sesiTerapis: List<SesiTerapis>) : HomeSesiTerapisUiState()
//    object Error : HomeSesiTerapisUiState()
//    object Loading : HomeSesiTerapisUiState()
//}
//
//class HomeSesiTerapisViewModel(
//    private val sesiTerapisRepository: SesiTerapisRepository
//) : ViewModel() {
//
//    var sesiTerapisUIState: HomeSesiTerapisUiState by mutableStateOf(HomeSesiTerapisUiState.Loading)
//        private set
//
//    init {
//        getSesiTerapis()
//    }
//
//    fun getSesiTerapis() {
//        viewModelScope.launch {
//            sesiTerapisUIState = HomeSesiTerapisUiState.Loading
//            sesiTerapisUIState = try {
//                HomeSesiTerapisUiState.Success(sesiTerapisRepository.getSesiTerapis())
//            } catch (e: IOException) {
//                HomeSesiTerapisUiState.Error
//            } catch (e: HttpException) {
//                HomeSesiTerapisUiState.Error
//            }
//        }
//    }
//
//    fun deleteSesiTerapis(id: String) {
//        viewModelScope.launch {
//            try {
//                sesiTerapisRepository.deleteSesiTerapis(id)
//            } catch (e: IOException) {
//                sesiTerapisUIState = HomeSesiTerapisUiState.Error
//            } catch (e: HttpException) {
//                sesiTerapisUIState = HomeSesiTerapisUiState.Error
//            }
//        }
//    }
//}
