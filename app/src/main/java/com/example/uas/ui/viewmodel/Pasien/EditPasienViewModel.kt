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
//data class EditPasienUiState(
//    val idPasien: String = "",
//    val namaPasien: String = "",
//    val alamat: String = "",
//    val nomorHp: String = "",
//    val tglLahir: String = "",
//    val riwayatMedikal: String = "",
//    val isLoading: Boolean = false,
//    val errorMessage: String? = null
//) {
//    fun toPasien(): Pasien {
//        return Pasien(
//            id_pasien = idPasien,
//            nama_pasien = namaPasien,
//            alamat = alamat,
//            nomor_hp = nomorHp,
//            tgl_lahir = tglLahir,
//            riwayat_medikal = riwayatMedikal
//        )
//    }
//}
//
//class EditPasienViewModel(
//    private val pasienRepository: PasienRepository,
//    private val idPasien: String
//) : ViewModel() {
//
//    private val _uiState = MutableStateFlow(EditPasienUiState(isLoading = true))
//    val uiState: StateFlow<EditPasienUiState> get() = _uiState
//
//    init {
//        fetchPasien()
//    }
//
//    private fun fetchPasien() {
//        viewModelScope.launch {
//            _uiState.value = _uiState.value.copy(isLoading = true)
//            try {
//                val pasien = pasienRepository.getPasienById(idPasien)
//                _uiState.value = EditPasienUiState(
//                    idPasien = pasien.id_pasien,
//                    namaPasien = pasien.nama_pasien,
//                    alamat = pasien.alamat,
//                    nomorHp = pasien.nomor_hp,
//                    tglLahir = pasien.tgl_lahir,
//                    riwayatMedikal = pasien.riwayat_medikal,
//                    isLoading = false
//                )
//            } catch (e: Exception) {
//                _uiState.value = _uiState.value.copy(
//                    isLoading = false,
//                    errorMessage = "Terjadi kesalahan saat memuat data pasien: ${e.message}"
//                )
//            }
//        }
//    }
//
//    fun updateField(field: String, value: String) {
//        _uiState.value = when (field) {
//            "namaPasien" -> _uiState.value.copy(namaPasien = value)
//            "alamat" -> _uiState.value.copy(alamat = value)
//            "nomorHp" -> _uiState.value.copy(nomorHp = value)
//            "tglLahir" -> _uiState.value.copy(tglLahir = value)
//            "riwayatMedikal" -> _uiState.value.copy(riwayatMedikal = value)
//            else -> _uiState.value
//        }
//    }
//
//    fun editPasien(onSuccess: () -> Unit, onError: (String) -> Unit) {
//        viewModelScope.launch {
//            _uiState.value = _uiState.value.copy(isLoading = true)
//            try {
//                val pasien = _uiState.value.toPasien()
//                pasienRepository.updatePasien(pasien.id_pasien, pasien)
//                _uiState.value = _uiState.value.copy(isLoading = false)
//                onSuccess()
//            } catch (e: Exception) {
//                _uiState.value = _uiState.value.copy(
//                    isLoading = false,
//                    errorMessage = "Terjadi kesalahan saat menyimpan data: ${e.message}"
//                )
//                onError(e.message ?: "Error tidak diketahui")
//            }
//        }
//    }
//
//    companion object {
//        fun provideFactory(
//            repository: PasienRepository,
//            idPasien: String
//        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
//            override fun <T : ViewModel> create(modelClass: Class<T>): T {
//                if (modelClass.isAssignableFrom(EditPasienViewModel::class.java)) {
//                    return EditPasienViewModel(repository, idPasien) as T
//                }
//                throw IllegalArgumentException("Unknown ViewModel class")
//            }
//        }
//    }
//}
