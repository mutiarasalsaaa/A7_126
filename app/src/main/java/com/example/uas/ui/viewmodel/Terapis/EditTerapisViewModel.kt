//package com.example.uas.ui.viewmodel.Terapis

//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.consumerestapi.model.Terapis
//import com.example.consumerestapi.repository.TerapisRepository
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//import kotlinx.coroutines.launch
//
//data class InsertUiStateTerapis(
//    val idTerapis: String = "",
//    val namaTerapis: String = "",
//    val spesialisasi: String = "",
//    val jenisKelamin: String = "",
//    val nomorHp: String = "",
//    val alamat: String = ""
//) {
//    fun toTerapis() = Terapis(
//        id_terapis = idTerapis,
//        nama_terapis = namaTerapis,
//        spesialisasi = spesialisasi,
//        jenis_kelamin = jenisKelamin,
//        nomor_hp = nomorHp,
//        alamat = alamat
//    )
//}
//
//class EditTerapisViewModel(
//    private val terapisRepository: TerapisRepository
//) : ViewModel() {
//
//    private val _uiState = MutableStateFlow(InsertUiStateTerapis())
//    val uiState: StateFlow<InsertUiStateTerapis> = _uiState
//
//    fun updateInsertTerapisState(field: String, value: String) {
//        _uiState.value = when (field) {
//            "namaTerapis" -> _uiState.value.copy(namaTerapis = value)
//            "spesialisasi" -> _uiState.value.copy(spesialisasi = value)
//            "jenisKelamin" -> _uiState.value.copy(jenisKelamin = value)
//            "nomorHp" -> _uiState.value.copy(nomorHp = value)
//            "alamat" -> _uiState.value.copy(alamat = value)
//            else -> _uiState.value
//        }
//    }
//
//    fun editTerapis() {
//        val updatedTerapis = _uiState.value.toTerapis()
//        viewModelScope.launch {
//            terapisRepository.updateTerapis(updatedTerapis.id_terapis, updatedTerapis)
//        }
//    }
//}
