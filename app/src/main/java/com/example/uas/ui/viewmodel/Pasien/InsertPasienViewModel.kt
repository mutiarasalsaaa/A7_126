//package com.example.uas.ui.viewmodel.Pasien
//
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.setValue
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.ViewModelProvider
//import androidx.lifecycle.viewModelScope
//import com.example.uas.Repository.NetworkPasienRepository
//import com.example.uas.model.Pasien
//import com.example.uas.ui.viewmodel.SesiTerapi.InsertUiEvent
//import com.example.uas.ui.viewmodel.SesiTerapi.InsertUiState
//import kotlinx.coroutines.launch
//
//class PasienViewModel(
//    private val repository: NetworkPasienRepository
//) : ViewModel() {
//
//    var uiState by mutableStateOf(InsertUiState())
//        private set
//
//    fun updateInsertPasienState(insertUiEvent: InsertUiEvent) {
//        uiState = InsertUiState(insertUiEvent)
//    }
//
//    fun insertPasien(onSuccess: () -> Unit = {}, onError: (String) -> Unit = {}) {
//        viewModelScope.launch {
//            try {
//                repository.insertPasien(uiState.insertUiEvent.toPasien())
//                onSuccess()
//            } catch (e: Exception) {
//                onError(e.message ?: "Terjadi kesalahan")
//            }
//        }
//    }
//
//    companion object {
//        val Factory: ViewModelProvider.Factory = ViewModelProvider.Factory { _, _ ->
//            // Implementasi factory untuk instansiasi ViewModel
//            PasienViewModel(NetworkPasienRepository(/* PasienService */))
//        }
//    }
//}
//
//fun InsertUiEvent.toPasien(): Pasien = Pasien(
//    id_pasien = id_pasien,
//    nama_pasien = nama_pasien,
//    alamat = alamat,
//    nomor_hp = nomor_hp,
//    tgl_lahir = tgl_lahir,
//    riwayat_medikal = riwayat_medikal
//)
