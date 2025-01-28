//package com.example.uas.ui.view.sesiTerapi
//
//import androidx.compose.foundation.layout.*
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Edit
//import androidx.compose.material3.*
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.input.nestedscroll.nestedScroll
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.lifecycle.viewmodel.compose.viewModel
//import com.example.uas.model.SesiTerapis
//import com.example.uas.ui.customwidget.CostumeTopAppBar
//import com.example.uas.ui.navigation.destinasiNavigasi
//import com.example.uas.ui.viewmodel.PenyediaViewModel
//
//object DestinasiDetailSesiTerapi : destinasiNavigasi {
//    override val route = "detail_sesi_terapi"
//    override val titleRes = "Detail Sesi Terapi"
//    const val id_sesi = "id_sesi"
//    val routeWithArgs = "$route/{$id_sesi}"
//}
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun DetailSesiTerapiView(
//    modifier: Modifier = Modifier,
//    navigateBack: () -> Unit,
//    onEditClick: (String) -> Unit,
//    detailViewModel: DetailSesiTerapiViewModel = viewModel(factory = PenyediaViewModel.Factory)
//) {
//    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
//
//    Scaffold(
//        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
//        topBar = {
//            CostumeTopAppBar(
//                title = DestinasiDetailSesiTerapi.titleRes,
//                canNavigateBack = true,
//                scrollBehavior = scrollBehavior,
//                navigateUp = navigateBack,
//            )
//        },
//        floatingActionButton = {
//            FloatingActionButton(
//                onClick = {
//                    val id_sesi = (detailViewModel.detailSesiTerapiUiState as? DetailSesiTerapiUiState.Success)?.sesiTerapis?.id_sesi
//                    if (id_sesi != null) onEditClick(id_sesi)
//                },
//                shape = MaterialTheme.shapes.medium
//            ) {
//                Icon(
//                    imageVector = Icons.Default.Edit,
//                    contentDescription = "Edit Sesi Terapi",
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
//            DetailSesiTerapiStatus(
//                sesiTerapiUiState = detailViewModel.detailSesiTerapiUiState,
//                retryAction = { detailViewModel.getSesiById() },
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
//fun DetailSesiTerapiStatus(
//    sesiTerapiUiState: DetailSesiTerapiUiState,
//    retryAction: () -> Unit,
//    modifier: Modifier = Modifier,
//) {
//    when (sesiTerapiUiState) {
//        is DetailSesiTerapiUiState.Success -> {
//            DetailSesiTerapiCard(
//                sesiTerapis = sesiTerapiUiState.sesiTerapis,
//                modifier = modifier.padding(16.dp)
//            )
//        }
//
//        is DetailSesiTerapiUiState.Loading -> {
//            Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
//                CircularProgressIndicator()
//            }
//        }
//
//        is DetailSesiTerapiUiState.Error -> {
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
//fun DetailSesiTerapiCard(
//    sesiTerapis: SesiTerapis,
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
//            ComponentDetailSesiTerapi(judul = "Id Sesi", isinya = sesiTerapis.id_sesi)
//            Spacer(modifier = Modifier.height(8.dp))
//            ComponentDetailSesiTerapi(judul = "Id Pasien", isinya = sesiTerapis.id_pasien)
//            Spacer(modifier = Modifier.height(8.dp))
//            ComponentDetailSesiTerapi(judul = "Id Terapis", isinya = sesiTerapis.id_terapis)
//            Spacer(modifier = Modifier.height(8.dp))
//            ComponentDetailSesiTerapi(judul = "Tanggal Sesi", isinya = sesiTerapis.tgl_sesi)
//        }
//    }
//}
//
//@Composable
//fun ComponentDetailSesiTerapi(
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
