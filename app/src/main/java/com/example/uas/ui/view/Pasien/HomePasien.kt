//package com.example.uas.ui.view.Pasien
//
//
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Add
//import androidx.compose.material.icons.filled.Delete
//import androidx.compose.material3.*
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.collectAsState
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//import androidx.lifecycle.viewmodel.compose.viewModel
//import com.example.uas.model.Pasien
//import com.example.uas.ui.customwidget.CostumeTopAppBar
//import com.example.uas.ui.navigation.destinasiNavigasi
//import com.example.uas.ui.viewmodel.Pasien.HomePasienViewModel
//import com.example.uas.ui.viewmodel.Pasien.HomeUiState
//
//object DestinasiHomePasien : destinasiNavigasi {
//    override val route = "home_pasien"
//    override val titleRes = "Home Pasien"
//}
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun HomePasienScreen(
//    navigateToItemEntry: () -> Unit,
//    modifier: Modifier = Modifier,
//    onDetailClick: (String) -> Unit = {},
//    viewModel: HomePasienViewModel = viewModel(factory = HomePasienViewModel.Factory)
//) {
//    val pasienUiState = viewModel.pasienUiState.collectAsState()
//
//    Scaffold(
//        topBar = {
//            CostumeTopAppBar(
//                title = DestinasiHomePasien.titleRes,
//                canNavigateBack = false,
//                onRefresh = { viewModel.getPasien() }
//            )
//        },
//        floatingActionButton = {
//            FloatingActionButton(
//                onClick = navigateToItemEntry,
//                shape = MaterialTheme.shapes.medium,
//                modifier = Modifier.padding(16.dp)
//            ) {
//                Icon(imageVector = Icons.Default.Add, contentDescription = "Tambah Pasien")
//            }
//        },
//        modifier = modifier
//    ) { innerPadding ->
//        Box(modifier = Modifier.padding(innerPadding)) {
//            HomePasienStatus(
//                homeUiState = pasienUiState.value,
//                onRetry = { viewModel.getPasien() },
//                onDetailClick = onDetailClick,
//                onDeleteClick = {
//                    viewModel.deletePasien(it.id_pasien)
//                }
//            )
//        }
//    }
//}
//
//@Composable
//fun HomePasienStatus(
//    homeUiState: HomeUiState,
//    onRetry: () -> Unit,
//    onDetailClick: (String) -> Unit,
//    onDeleteClick: (Pasien) -> Unit
//) {
//    when (homeUiState) {
//        is HomeUiState.Loading -> LoadingContent()
//        is HomeUiState.Success -> {
//            if (homeUiState.pasien.isEmpty()) {
//                EmptyContent()
//            } else {
//                PasienList(
//                    pasien = homeUiState.pasien,
//                    onDetailClick = { onDetailClick(it.id_pasien) },
//                    onDeleteClick = onDeleteClick
//                )
//            }
//        }
//        is HomeUiState.Error -> ErrorContent(message = homeUiState.message, onRetry = onRetry)
//    }
//}
//
//@Composable
//fun LoadingContent() {
//    Box(
//        modifier = Modifier
//            .fillMaxSize(),
//        contentAlignment = Alignment.Center
//    ) {
//        CircularProgressIndicator()
//    }
//}
//
//@Composable
//fun EmptyContent() {
//    Box(
//        modifier = Modifier
//            .fillMaxSize(),
//        contentAlignment = Alignment.Center
//    ) {
//        Text(text = "Data Pasien Kosong", style = MaterialTheme.typography.bodyLarge)
//    }
//}
//
//@Composable
//fun ErrorContent(message: String, onRetry: () -> Unit) {
//    Box(
//        modifier = Modifier
//            .fillMaxSize(),
//        contentAlignment = Alignment.Center
//    ) {
//        Column(horizontalAlignment = Alignment.CenterHorizontally) {
//            Text(text = "Terjadi Kesalahan: $message", style = MaterialTheme.typography.bodyLarge)
//            Spacer(modifier = Modifier.height(8.dp))
//            Button(onClick = onRetry) {
//                Text(text = "Coba Lagi")
//            }
//        }
//    }
//}
//
//@Composable
//fun PasienList(
//    pasien: List<Pasien>,
//    onDetailClick: (Pasien) -> Unit,
//    onDeleteClick: (Pasien) -> Unit
//) {
//    LazyColumn(
//        contentPadding = PaddingValues(16.dp),
//        verticalArrangement = Arrangement.spacedBy(8.dp)
//    ) {
//        items(pasien) { item ->
//            PasienCard(
//                pasien = item,
//                onDetailClick = { onDetailClick(item) },
//                onDeleteClick = { onDeleteClick(item) }
//            )
//        }
//    }
//}
//
//@Composable
//fun PasienCard(
//    pasien: Pasien,
//    onDetailClick: () -> Unit,
//    onDeleteClick: () -> Unit
//) {
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .clickable(onClick = onDetailClick),
//        elevation = CardDefaults.cardElevation(4.dp)
//    ) {
//        Column(modifier = Modifier.padding(16.dp)) {
//            Text(text = pasien.nama_pasien, style = MaterialTheme.typography.titleLarge)
//            Spacer(modifier = Modifier.height(4.dp))
//            Text(text = "Alamat: ${pasien.alamat}", style = MaterialTheme.typography.bodyMedium)
//            Spacer(modifier = Modifier.height(4.dp))
//            Text(text = "No. HP: ${pasien.nomor_hp}", style = MaterialTheme.typography.bodyMedium)
//            Spacer(modifier = Modifier.height(8.dp))
//            Text(text = pasien.riwayat_medikal, style = MaterialTheme.typography.titleLarge)
//            Spacer(modifier = Modifier.height(4.dp))
//            IconButton(onClick = onDeleteClick) {
//                Icon(imageVector = Icons.Default.Delete, contentDescription = "Hapus Pasien")
//            }
//        }
//    }
//}
