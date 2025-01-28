//package com.example.uas.ui.view.SesiTerapi
//
//package com.example.consumerestapi.ui.screens
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Add
//import androidx.compose.material.icons.filled.Delete
//import androidx.compose.material3.*
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.res.stringResource
//import androidx.compose.ui.unit.dp
//import androidx.lifecycle.viewmodel.compose.viewModel
//import com.example.consumerestapi.R
//import com.example.consumerestapi.model.SesiTerapis
//import com.example.consumerestapi.ui.CostumeWidget.CostumeTopAppBar
//import com.example.consumerestapi.ui.Navigasi.DestinasiNavigasi
//import com.example.consumerestapi.ui.viewmodel.HomeSesiTerapisViewModel
//import com.example.consumerestapi.ui.viewmodel.HomeUiState
//import com.example.consumerestapi.ui.viewmodel.PenyediaViewModel
//
//object DestinasiHomeSesiTerapis : DestinasiNavigasi {
//    override val route = "home_sesiterapis"
//    override val titleRes = "Home Sesi Terapis"
//}
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun HomeSesiTerapisScreen(
//    navigateToItemEntry: () -> Unit,
//    modifier: Modifier = Modifier,
//    onDetailClick: (String) -> Unit = {},
//    viewModel: HomeSesiTerapisViewModel = viewModel(factory = PenyediaViewModel.Factory)
//) {
//    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
//    Scaffold(
//        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
//        topBar = {
//            CostumeTopAppBar(
//                title = DestinasiHomeSesiTerapis.titleRes,
//                canNavigateBack = false,
//                scrollBehavior = scrollBehavior,
//                onRefresh = { viewModel.getSesiTerapis() }
//            )
//        },
//        floatingActionButton = {
//            FloatingActionButton(
//                onClick = navigateToItemEntry,
//                shape = MaterialTheme.shapes.medium,
//                modifier = Modifier.padding(18.dp)
//            ) {
//                Icon(imageVector = Icons.Default.Add, contentDescription = "Tambah Sesi Terapis")
//            }
//        },
//    ) { innerPadding ->
//        HomeSesiTerapisStatus(
//            homeUiState = viewModel.sesiTerapisUiState,
//            retryAction = { viewModel.getSesiTerapis() },
//            modifier = Modifier.padding(innerPadding),
//            onDetailClick = onDetailClick,
//            onDeleteClick = {
//                viewModel.deleteSesiTerapis(it.idSesi)
//                viewModel.getSesiTerapis()
//            }
//        )
//    }
//}
//
//@Composable
//fun HomeSesiTerapisStatus(
//    homeUiState: HomeUiState,
//    retryAction: () -> Unit,
//    modifier: Modifier = Modifier,
//    onDetailClick: (String) -> Unit,
//    onDeleteClick: (SesiTerapis) -> Unit = {}
//) {
//    when (homeUiState) {
//        is HomeUiState.Loading -> OnLoading(modifier = modifier.fillMaxSize())
//        is HomeUiState.Success -> {
//            if (homeUiState.sesiTerapis.isEmpty()) {
//                Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
//                    Text(text = "Tidak ada data Sesi Terapis")
//                }
//            } else {
//                SesiTerapisLayout(
//                    sesiTerapis = homeUiState.sesiTerapis,
//                    modifier = modifier.fillMaxWidth(),
//                    onDetailClick = { onDetailClick(it.idSesi) },
//                    onDeleteClick = { onDeleteClick(it) }
//                )
//            }
//        }
//        is HomeUiState.Error -> OnError(retryAction, modifier = modifier.fillMaxSize())
//    }
//}
//
//@Composable
//fun SesiTerapisLayout(
//    sesiTerapis: List<SesiTerapis>,
//    modifier: Modifier = Modifier,
//    onDetailClick: (SesiTerapis) -> Unit,
//    onDeleteClick: (SesiTerapis) -> Unit = {}
//) {
//    LazyColumn(
//        modifier = modifier,
//        contentPadding = PaddingValues(16.dp),
//        verticalArrangement = Arrangement.spacedBy(16.dp)
//    ) {
//        items(sesiTerapis) { item ->
//            SesiTerapisCard(
//                sesiTerapis = item,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .clickable { onDetailClick(item) },
//                onDeleteClick = { onDeleteClick(item) }
//            )
//        }
//    }
//}
//
//@Composable
//fun SesiTerapisCard(
//    sesiTerapis: SesiTerapis,
//    modifier: Modifier = Modifier,
//    onDeleteClick: (SesiTerapis) -> Unit = {}
//) {
//    Card(
//        modifier = modifier,
//        shape = MaterialTheme.shapes.medium,
//        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
//    ) {
//        Column(
//            modifier = Modifier.padding(16.dp),
//            verticalArrangement = Arrangement.spacedBy(8.dp)
//        ) {
//            Row(
//                modifier = Modifier.fillMaxWidth(),
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//                Text(
//                    text = sesiTerapis.namaTerapis,
//                    style = MaterialTheme.typography.titleLarge,
//                )
//                Spacer(Modifier.weight(1f))
//                IconButton(onClick = { onDeleteClick(sesiTerapis) }) {
//                    Icon(
//                        imageVector = Icons.Default.Delete,
//                        contentDescription = null,
//                    )
//                }
//            }
//            Text(
//                text = sesiTerapis.jenisTerapis,
//                style = MaterialTheme.typography.titleMedium
//            )
//            Text(
//                text = sesiTerapis.jamSesi,
//                style = MaterialTheme.typography.titleMedium
//            )
//        }
//    }
//}
