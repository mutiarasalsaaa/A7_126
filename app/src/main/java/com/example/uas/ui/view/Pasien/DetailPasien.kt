//package com.example.uas.ui.view.Pasien
//
//import androidx.compose.foundation.layout.*
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.ArrowBack
//import androidx.compose.material3.*
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.collectAsState
//import androidx.compose.runtime.getValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//import androidx.lifecycle.viewmodel.compose.viewModel
//import com.example.uas.Repository.PasienRepository
//import com.example.uas.ui.viewmodel.Pasien.DetailPasienUiState
//import com.example.uas.ui.viewmodel.Pasien.DetailPasienViewModel
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun DetailPasienView(
//    idPasien: String,
//    navigateBack: () -> Unit,
//    viewModel: DetailPasienViewModel = viewModel(factory = DetailPasienViewModel.provideFactory(repository = PasienRepository(), idPasien = idPasien))
//) {
//    val uiState by viewModel.uiState.collectAsState()
//
//    Scaffold(
//        topBar = {
//            TopAppBar(
//                title = { Text("Detail Pasien") },
//                navigationIcon = {
//                    IconButton(onClick = navigateBack) {
//                        Icon(Icons.Default.ArrowBack, contentDescription = "Kembali")
//                    }
//                }
//            )
//        }
//    ) { paddingValues ->
//        when (uiState) {
//            is DetailPasienUiState.Loading -> {
//                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
//                    CircularProgressIndicator()
//                }
//            }
//
//            is DetailPasienUiState.Success -> {
//                val pasien = (uiState as DetailPasienUiState.Success).pasien
//                Column(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .padding(paddingValues)
//                        .padding(16.dp),
//                    verticalArrangement = Arrangement.spacedBy(16.dp)
//                ) {
//                    Text("Nama: ${pasien.nama_pasien}", style = MaterialTheme.typography.bodyLarge)
//                    Text("Alamat: ${pasien.alamat}", style = MaterialTheme.typography.bodyLarge)
//                    Text("Nomor HP: ${pasien.nomor_hp}", style = MaterialTheme.typography.bodyLarge)
//                    Text("Tanggal Lahir: ${pasien.tgl_lahir}", style = MaterialTheme.typography.bodyLarge)
//                    Text("Riwayat Medikal: ${pasien.riwayat_medikal}", style = MaterialTheme.typography.bodyLarge)
//                }
//            }
//
//            is DetailPasienUiState.Error -> {
//                val message = (uiState as DetailPasienUiState.Error).message
//                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
//                    Text("Terjadi kesalahan: $message", style = MaterialTheme.typography.bodyLarge, color = MaterialTheme.colorScheme.error)
//                }
//            }
//        }
//    }
//}
