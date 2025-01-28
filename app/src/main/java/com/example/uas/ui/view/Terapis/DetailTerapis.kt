//package com.example.uas.ui.view.Terapis
//
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.offset
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Edit
//import androidx.compose.material3.Button
//import androidx.compose.material3.Card
//import androidx.compose.material3.CardDefaults
//import androidx.compose.material3.CircularProgressIndicator
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.FloatingActionButton
//import androidx.compose.material3.Icon
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.material3.TopAppBarDefaults
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.input.nestedscroll.nestedScroll
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.lifecycle.viewmodel.compose.viewModel
//import com.example.uas.ui.customwidget.CostumeTopAppBar
//import com.example.uas.ui.navigation.destinasiNavigasi
//import com.example.uas.ui.viewmodel.PenyediaViewModel
//
//object DestinasiDetailTerapis : destinasiNavigasi {
//    override val route = "terapis_detail"
//    override val titleRes = "Detail Terapis"
//    const val idTerapis = "id_terapis"
//    val routeWithArgs = "$route/{$idTerapis}"
//}
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun DetailTerapisView(
//    modifier: Modifier = Modifier,
//    navigateBack: () -> Unit,
//    onEditClick: (String) -> Unit,
//    detailTerapisViewModel: DetailTerapisViewModel = viewModel(factory = PenyediaViewModel.Factory)
//) {
//    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
//
//    Scaffold(
//        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
//        topBar = {
//            CostumeTopAppBar(
//                title = DestinasiDetailTerapis.titleRes,
//                canNavigateBack = true,
//                scrollBehavior = scrollBehavior,
//                navigateUp = navigateBack
//            )
//        },
//        floatingActionButton = {
//            FloatingActionButton(
//                onClick = {
//                    val idTerapis = (detailTerapisViewModel.detailTerapisUiState as? DetailTerapisUiState.Success)?.terapis?.idTerapis
//                    if (idTerapis != null) onEditClick(idTerapis)
//                },
//                shape = MaterialTheme.shapes.medium
//            ) {
//                Icon(
//                    imageVector = Icons.Default.Edit,
//                    contentDescription = "Edit Terapis",
//                )
//            }
//        }
//    ) { innerPadding ->
//        Box(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(innerPadding)
//                .offset(y = (-70).dp)
//        ) {
//            DetailTerapisStatus(
//                terapisUiState = detailTerapisViewModel.detailTerapisUiState,
//                retryAction = { detailTerapisViewModel.getTerapisById() },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .align(Alignment.Center)
//                    .padding(16.dp)
//            )
//        }
//    }
//}
//
//@Composable
//fun DetailTerapisStatus(
//    terapisUiState: DetailTerapisUiState,
//    retryAction: () -> Unit,
//    modifier: Modifier = Modifier,
//) {
//    when (terapisUiState) {
//        is DetailTerapisUiState.Success -> {
//            DetailTerapisCard(
//                terapis = terapisUiState.terapis,
//                modifier = modifier.padding(16.dp)
//            )
//        }
//
//        is DetailTerapisUiState.Loading -> {
//            Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
//                CircularProgressIndicator()
//            }
//        }
//
//        is DetailTerapisUiState.Error -> {
//            Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
//                Column(horizontalAlignment = Alignment.CenterHorizontally) {
//                    Text(text = "Terjadi kesalahan.")
//                    Spacer(modifier = Modifier.height(8.dp))
//                    Button(onClick = retryAction) {
//                        Text(text = "Coba Lagi")
//                    }
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun DetailTerapisCard(
//    terapis: Terapis,
//    modifier: Modifier = Modifier
//) {
//    Card(
//        modifier = modifier,
//        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
//        shape = MaterialTheme.shapes.medium
//    ) {
//        Column(
//            modifier = Modifier.padding(16.dp),
//            verticalArrangement = Arrangement.spacedBy(8.dp)
//        ) {
//            ComponentDetailTerapis(judul = "ID Terapis", isinya = terapis.idTerapis)
//            Spacer(modifier = Modifier.height(8.dp))
//            ComponentDetailTerapis(judul = "Nama", isinya = terapis.nama)
//            Spacer(modifier = Modifier.height(8.dp))
//            ComponentDetailTerapis(judul = "Alamat", isinya = terapis.alamat)
//            Spacer(modifier = Modifier.height(8.dp))
//            ComponentDetailTerapis(judul = "Spesialisasi", isinya = terapis.spesialisasi)
//            Spacer(modifier = Modifier.height(8.dp))
//            ComponentDetailTerapis(judul = "Nomor HP", isinya = terapis.nomorHp)
//        }
//    }
//}
//
//@Composable
//fun ComponentDetailTerapis(
//    modifier: Modifier = Modifier,
//    judul: String,
//    isinya: String,
//) {
//    Row(
//        modifier = modifier.fillMaxWidth(),
//        horizontalArrangement = Arrangement.SpaceBetween
//    ) {
//        Text(
//            text = "$judul:",
//            fontSize = 20.sp,
//            fontWeight = FontWeight.Bold,
//            color = Color.Gray
//        )
//        Text(
//            text = isinya,
//            fontSize = 20.sp,
//            fontWeight = FontWeight.Bold,
//        )
//    }
//}
