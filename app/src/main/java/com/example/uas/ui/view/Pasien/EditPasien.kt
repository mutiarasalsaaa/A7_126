//package com.example.uas.ui.view.Pasien
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.uas.Repository.PasienRepository
//import com.example.uas.model.Pasien
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//import kotlinx.coroutines.launch
//
//data class InsertUiStatePasien(
//    val idPasien: String = "",
//    val namaPasien: String = "",
//    val alamat: String = "",
//    val nomorHp: String = "",
//    val tglLahir: String = "",
//    val riwayatMedikal: String = ""
//) {
//    fun toPasien() = Pasien(
//        id_pasien = idPasien,
//        nama_pasien = namaPasien,
//        alamat = alamat,
//        nomor_hp = nomorHp,
//        tgl_lahir = tglLahir,
//        riwayat_medikal = riwayatMedikal
//    )
//}
//
//class EditPasienViewModel(
//    private val pasienRepository: PasienRepository
//) : ViewModel() {
//
//    private val _uiState = MutableStateFlow(InsertUiStatePasien())
//    val uiState: StateFlow<InsertUiStatePasien> get() = _uiState
//
//    fun updateInsertPasienState(field: String, value: String) {
//        _uiState.value = _uiState.value.copy(
//            namaPasien = if (field == "namaPasien") value else _uiState.value.namaPasien,
//            alamat = if (field == "alamat") value else _uiState.value.alamat,
//            nomorHp = if (field == "nomorHp") value else _uiState.value.nomorHp,
//            tglLahir = if (field == "tglLahir") value else _uiState.value.tglLahir,
//            riwayatMedikal = if (field == "riwayatMedikal") value else _uiState.value.riwayatMedikal
//        )
//    }
//
//    fun editPasien() {
//        viewModelScope.launch {
//            val pasien = _uiState.value.toPasien()
//            pasienRepository.updatePasien(pasien.id_pasien, pasien)
//        }
//    }
//}
