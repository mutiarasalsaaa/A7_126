//package com.example.uas.ui.viewmodel.Pasien
//
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
//sealed class HomeUiState {
//    object Loading : HomeUiState()
//    data class Success(val pasien: List<Pasien>) : HomeUiState()
//    data class Error(val message: String) : HomeUiState()
//}
//
//class HomePasienViewModel(
//    private val pasienRepository: PasienRepository
//) : ViewModel() {
//
//    private val _pasienUiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
//    val pasienUiState: StateFlow<HomeUiState> get() = _pasienUiState
//
//    init {
//        getPasien()
//    }
//
//    fun getPasien() {
//        viewModelScope.launch {
//            _pasienUiState.value = HomeUiState.Loading
//            try {
//                val pasienList = pasienRepository.getPasien()
//                _pasienUiState.value = HomeUiState.Success(pasienList)
//            } catch (e: Exception) {
//                _pasienUiState.value = HomeUiState.Error(e.localizedMessage ?: "Terjadi kesalahan")
//            }
//        }
//    }
//
//    fun deletePasien(idPasien: String) {
//        viewModelScope.launch {
//            try {
//                pasienRepository.deletePasien(idPasien)
//                getPasien() // Refresh data setelah delete
//            } catch (e: Exception) {
//                _pasienUiState.value = HomeUiState.Error(e.localizedMessage ?: "Gagal menghapus pasien")
//            }
//        }
//    }
//
//    companion object {
//        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
//            @Suppress("UNCHECKED_CAST")
//            override fun <T : ViewModel> create(modelClass: Class<T>): T {
//                val repository = PasienRepository.PasienRepository()
//                return HomePasienViewModel(repository) as T
//            }
//        }
//    }
//}
