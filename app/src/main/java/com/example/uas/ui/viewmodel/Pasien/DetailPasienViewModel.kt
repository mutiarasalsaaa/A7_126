//package com.example.uas.ui.viewmodel.Pasien
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.ViewModelProvider
//import androidx.lifecycle.viewModelScope
//import com.example.uas.Repository.PasienRepository
//import com.example.uas.model.Pasien
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//import kotlinx.coroutines.launch
//
//sealed class DetailPasienUiState {
//    object Loading : DetailPasienUiState()
//    data class Success(val pasien: Pasien) : DetailPasienUiState()
//    data class Error(val message: String) : DetailPasienUiState()
//}
//
//class DetailPasienViewModel(
//    private val repository: PasienRepository,
//    private val idPasien: String
//) : ViewModel() {
//
//    private val _uiState = MutableStateFlow<DetailPasienUiState>(DetailPasienUiState.Loading)
//    val uiState: StateFlow<DetailPasienUiState> = _uiState
//
//    init {
//        fetchPasienById()
//    }
//
//    private fun fetchPasienById() {
//        viewModelScope.launch {
//            _uiState.value = DetailPasienUiState.Loading
//            try {
//                val pasien = repository.getPasienById(idPasien)
//                _uiState.value = DetailPasienUiState.Success(pasien)
//            } catch (e: Exception) {
//                _uiState.value = DetailPasienUiState.Error("Terjadi kesalahan: ${e.message}")
//            }
//        }
//    }
//
//    companion object {
//        fun provideFactory(
//            repository: PasienRepository,
//            idPasien: String
//        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
//            @Suppress("UNCHECKED_CAST")
//            override fun <T : ViewModel> create(modelClass: Class<T>): T {
//                if (modelClass.isAssignableFrom(DetailPasienViewModel::class.java)) {
//                    return DetailPasienViewModel(repository, idPasien) as T
//                }
//                throw IllegalArgumentException("Unknown ViewModel class")
//            }
//        }
//    }
//}
