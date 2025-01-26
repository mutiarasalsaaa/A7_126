package com.example.uas.ui.view.JenisTerapis

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.uas.model.JenisTerapis
import com.example.uas.ui.customwidget.CostumeTopAppBar
import com.example.uas.ui.navigation.destinasiNavigasi
import com.example.uas.ui.viewmodel.JenisTerapis.DetailJenisTerapisViewModel
import com.example.uas.ui.viewmodel.JenisTerapis.DetailJnsUiState
import com.example.uas.ui.viewmodel.PenyediaViewModel

object DestinasiDetailJenisTerapis : destinasiNavigasi {
    override val route = "detailjenisTerapis"
    override val titleRes = "Detail JenisTerapis"
    const val id_jenis_terapis = "id_jenis_terapis"
    val routeWithArgs = "$route/{$id_jenis_terapis}"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailJenisTerapisView(
    modifier: Modifier = Modifier,
    navigateBack: () -> Unit,
    onEditClick: (String) -> Unit,
    detailjenisTerapisViewModel: DetailJenisTerapisViewModel = viewModel(factory = PenyediaViewModel.Factory)
){
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CostumeTopAppBar(
                title = DestinasiDetailJenisTerapis.titleRes,
                canNavigateBack = true,
                scrollBehavior = scrollBehavior,
                navigateUp = navigateBack
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    val id_jenisTerapis = (detailjenisTerapisViewModel.detailJnsUiState as? DetailJnsUiState.Success)?.jenisterapi?.id_jenis_terapis
                    if (id_jenisTerapis != null) onEditClick(id_jenisTerapis)
                },
                shape = MaterialTheme.shapes.medium
            ) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Edit JenisTerapis",
                )
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding).offset(y = (-70).dp)
        ) {
            DetailStatus(
                jnsUiState = detailjenisTerapisViewModel.detailJnsUiState,
                retryAction = { detailjenisTerapisViewModel.getJnsById() },
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center)
                    .padding(16.dp)
            )
        }
    }
}

@Composable
fun DetailStatus(
    jnsUiState: DetailJnsUiState,
    retryAction: () -> Unit,
    modifier: Modifier = Modifier,
) {
    when (jnsUiState) {
        is DetailJnsUiState.Success -> {
            DetailCard(
                jenisTerapis = jnsUiState.jenisterapi,
                modifier = modifier.padding(16.dp)
            )
        }

        is DetailJnsUiState.Loading -> {
            Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }

        is DetailJnsUiState.Error -> {
            Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "Terjadi kesalahan.")
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(onClick = retryAction) {
                        Text(text = "Coba Lagi")
                    }
                }
            }
        }
    }
}

@Composable
fun DetailCard(
    jenisTerapis: JenisTerapis,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        shape = MaterialTheme.shapes.medium
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            //horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            ComponentDetailJns(judul = "Id_JenisTerapis", isinya = jenisTerapis.id_jenis_terapis)
            Spacer(modifier = Modifier.height(8.dp))
            ComponentDetailJns(judul = "Nama_JenisTerapis", isinya = jenisTerapis.nama_jenis_terapi)
            Spacer(modifier = Modifier.height(8.dp))
            ComponentDetailJns(judul = "Deskripsi", isinya = jenisTerapis.deskripsi_terapi)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun ComponentDetailJns(
    modifier: Modifier = Modifier,
    judul: String,
    isinya: String,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "$judul:",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Gray
        )
        Text(
            text = isinya,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}