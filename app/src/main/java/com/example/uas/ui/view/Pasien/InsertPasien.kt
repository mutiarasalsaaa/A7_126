//package com.example.uas.ui.view.Pasien
//
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.rememberScrollState
//import androidx.compose.foundation.text.KeyboardOptions
//import androidx.compose.foundation.verticalScroll
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.ArrowBack
//import androidx.compose.material3.*
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.rememberCoroutineScope
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.text.input.KeyboardType
//import androidx.compose.ui.unit.dp
//import androidx.lifecycle.viewmodel.compose.viewModel
//import com.example.uas.model.Pasien
//import com.example.uas.ui.viewmodel.Pasien.PasienViewModel
//import kotlinx.coroutines.launch
//
//@Composable
//fun InsertPasienScreen(
//    navigateBack: () -> Unit,
//    modifier: Modifier = Modifier,
//    viewModel: PasienViewModel = viewModel(factory = PasienViewModel.Factory)
//) {
//    val coroutineScope = rememberCoroutineScope()
//
//    // Scaffold setup with TopAppBar and other UI elements
//    Scaffold(
//        topBar = {
//            TopAppBar(
//                title = { Text("Entry Pasien") },
//                navigationIcon = {
//                    IconButton(onClick = navigateBack) {
//                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
//                    }
//                }
//            )
//        },
//        modifier = modifier.fillMaxSize()
//    ) { innerPadding ->
//        // Main body of the screen where form input is handled
//        Column(
//            modifier = Modifier
//                .padding(innerPadding)
//                .verticalScroll(rememberScrollState())
//                .fillMaxWidth()
//                .padding(12.dp)
//        ) {
//            // Form input fields
//            OutlinedTextField(
//                value = viewModel.uiState.insertUiEvent.nama_pasien,
//                onValueChange = {
//                    viewModel.updateInsertPasienState(viewModel.uiState.insertUiEvent.copy(nama_pasien = it))
//                },
//                label = { Text("Nama Pasien") },
//                modifier = Modifier.fillMaxWidth(),
//                singleLine = true
//            )
//            OutlinedTextField(
//                value = viewModel.uiState.insertUiEvent.id_pasien,
//                onValueChange = {
//                    viewModel.updateInsertPasienState(viewModel.uiState.insertUiEvent.copy(id_pasien = it))
//                },
//                label = { Text("ID Pasien") },
//                modifier = Modifier.fillMaxWidth(),
//                singleLine = true
//            )
//            OutlinedTextField(
//                value = viewModel.uiState.insertUiEvent.alamat,
//                onValueChange = {
//                    viewModel.updateInsertPasienState(viewModel.uiState.insertUiEvent.copy(alamat = it))
//                },
//                label = { Text("Alamat") },
//                modifier = Modifier.fillMaxWidth(),
//                singleLine = true
//            )
//            OutlinedTextField(
//                value = viewModel.uiState.insertUiEvent.nomor_hp,
//                onValueChange = {
//                    viewModel.updateInsertPasienState(viewModel.uiState.insertUiEvent.copy(nomor_hp = it))
//                },
//                label = { Text("Nomor HP") },
//                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
//                modifier = Modifier.fillMaxWidth(),
//                singleLine = true
//            )
//            OutlinedTextField(
//                value = viewModel.uiState.insertUiEvent.tgl_lahir,
//                onValueChange = {
//                    viewModel.updateInsertPasienState(viewModel.uiState.insertUiEvent.copy(tgl_lahir = it))
//                },
//                label = { Text("Tanggal Lahir") },
//                modifier = Modifier.fillMaxWidth(),
//                singleLine = true
//            )
//            OutlinedTextField(
//                value = viewModel.uiState.insertUiEvent.riwayat_medikal,
//                onValueChange = {
//                    viewModel.updateInsertPasienState(viewModel.uiState.insertUiEvent.copy(riwayat_medikal = it))
//                },
//                label = { Text("Riwayat Medikal") },
//                modifier = Modifier.fillMaxWidth(),
//                singleLine = true
//            )
//
//            // Submit Button
//            Spacer(modifier = Modifier.height(16.dp))
//            Button(
//                onClick = {
//                    coroutineScope.launch {
//                        viewModel.insertPasien(
//                            onSuccess = navigateBack,
//                            onError = { /* Handle error if needed */ }
//                        )
//                    }
//                },
//                modifier = Modifier.fillMaxWidth()
//            ) {
//                Text("Simpan")
//            }
//        }
//    }
//}
//
//// InsertUiEvent and InsertUiState classes for mapping input to Pasien data
//data class InsertUiEvent(
//    val id_pasien: String = "",
//    val nama_pasien: String = "",
//    val alamat: String = "",
//    val nomor_hp: String = "",
//    val tgl_lahir: String = "",
//    val riwayat_medikal: String = ""
//)
//
//fun InsertUiEvent.toPasien() = Pasien(
//    id_pasien = id_pasien,
//    nama_pasien = nama_pasien,
//    alamat = alamat,
//    nomor_hp = nomor_hp,
//    tgl_lahir = tgl_lahir,
//    riwayat_medikal = riwayat_medikal
//)
//
//fun Pasien.toInsertUiEvent() = InsertUiEvent(
//    id_pasien = id_pasien,
//    nama_pasien = nama_pasien,
//    alamat = alamat,
//    nomor_hp = nomor_hp,
//    tgl_lahir = tgl_lahir,
//    riwayat_medikal = riwayat_medikal
//)
