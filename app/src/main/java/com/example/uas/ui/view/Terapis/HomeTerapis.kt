//package com.example.uas.ui.view.Terapis
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
//import com.example.consumerestapi.model.Terapis
//import com.example.consumerestapi.ui.CostumeWidget.CostumeTopAppBar
//import com.example.consumerestapi.ui.Navigasi.DestinasiNavigasi
//import com.example.consumerestapi.ui.viewmodel.HomeTerapisViewModel
//import com.example.consumerestapi.ui.viewmodel.HomeUiState
//import com.example.consumerestapi.ui.viewmodel.PenyediaViewModel
//
//object DestinasiHomeTerapis : DestinasiNavigasi {
//    override val route = "home_terapis"
//    override val titleRes = "Home Terapis"
//}
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun HomeTerapisScreen(
//    navigateToItemEntry: () -> Unit,
//    modifier: Modifier = Modifier,
//    onDetailClick: (String) -> Unit = {},
//    viewModel: HomeTerapisViewModel = viewModel(factory = PenyediaViewModel.Factory)
//) {
//    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
//    Scaffold(
//        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
//        topBar = {
//            CostumeTopAppBar(
//                title = DestinasiHomeTerapis.titleRes,
//                canNavigateBack = false,
//                scrollBehavior = scrollBehavior,
//                onRefresh = { viewModel.getTerapis() }
//            )
//        },
//        floatingActionButton = {
//            FloatingActionButton(
//                onClick = navigateToItemEntry,
//                shape = MaterialTheme.shapes.medium,
//                modifier = Modifier.padding(18.dp)
//            ) {
//                Icon(imageVector = Icons.Default.Add, contentDescription = "Tambah Terapis")
//            }
//        },
//    ) { innerPadding ->
//        HomeTerapisStatus(
//            homeUiState = viewModel.terapisUiState,
//            retryAction = { viewModel.getTerapis() },
//            modifier = Modifier.padding(innerPadding),
//            onDetailClick = onDetailClick,
//            onDeleteClick = {
//                viewModel.deleteTerapis(it.idTerapis)
//                viewModel.getTerapis()
//            }
//        )
//    }
//}
//
//@Composable
//fun HomeTerapisStatus(
//    homeUiState: HomeUiState,
//    retryAction: () -> Unit,
//    modifier: Modifier = Modifier,
//    onDetailClick: (String) -> Unit,
//    onDeleteClick: (Terapis) -> Unit = {}
//) {
//    when (homeUiState) {
//        is HomeUiState.Loading -> OnLoading(modifier = modifier.fillMaxSize())
//        is HomeUiState.Success -> {
//            if (homeUiState.terapis.isEmpty()) {
//                Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
//                    Text(text = "Tidak ada data Terapis")
//                }
//            } else {
//                TerapisLayout(
//                    terapis = homeUiState.terapis,
//                    modifier = modifier.fillMaxWidth(),
//                    onDetailClick = { onDetailClick(it.idTerapis) },
//                    onDeleteClick = { onDeleteClick(it) }
//                )
//            }
//        }
//        is HomeUiState.Error -> OnError(retryAction, modifier = modifier.fillMaxSize())
//    }
//}
//
//@Composable
//fun TerapisLayout(
//    terapis: List<Terapis>,
//    modifier: Modifier = Modifier,
//    onDetailClick: (Terapis) -> Unit,
//    onDeleteClick: (Terapis) -> Unit = {}
//) {
//    LazyColumn(
//        modifier = modifier,
//        contentPadding = PaddingValues(16.dp),
//        verticalArrangement = Arrangement.spacedBy(16.dp)
//    ) {
//        items(terapis) { item ->
//            TerapisCard(
//                terapis = item,
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
//fun TerapisCard(
//    terapis: Terapis,
//    modifier: Modifier = Modifier,
//    onDeleteClick: (Terapis) -> Unit = {}
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
//                    text = terapis.namaTerapis,
//                    style = MaterialTheme.typography.titleLarge,
//                )
//                Spacer(Modifier.weight(1f))
//                IconButton(onClick = { onDeleteClick(terapis) }) {
//                    Icon(
//                        imageVector = Icons.Default.Delete,
//                        contentDescription = null,
//                    )
//                }
//            }
//            Text(
//                text = terapis.jenisTerapis,
//                style = MaterialTheme.typography.titleMedium
//            )
//            Text(
//                text = terapis.jadwalTerapis,
//                style = MaterialTheme.typography.titleMedium
//            )
//        }
//    }
//}
//
//@Composable
//fun OnLoading(modifier: Modifier = Modifier) {
//    Image(
//        modifier = modifier.size(200.dp),
//        painter = painterResource(R.drawable.loading_img),
//        contentDescription = stringResource(R.string.loading)
//    )
//}
//
//@Composable
//fun OnError(retryAction: () -> Unit, modifier: Modifier = Modifier) {
//    Column(
//        modifier = modifier,
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Image(
//            painter = painterResource(id = R.drawable.ic_connection_error),
//            contentDescription = ""
//        )
//        Text(text = stringResource(R.string.loading_failed), modifier = Modifier.padding(16.dp))
//        Button(onClick = retryAction) {
//            Text(stringResource(R.string.retry))
//        }
//    }
//}
