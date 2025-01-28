package com.example.uas.ui.view.JenisTerapis

import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.finalpam.ui.viewmodel.jenisTerapi.EditJenisTerapisViewModel
import com.example.uas.ui.customwidget.CostumeTopAppBar
import com.example.uas.ui.navigation.destinasiNavigasi
import com.example.uas.ui.viewmodel.PenyediaViewModel
import kotlinx.coroutines.launch

object DestinasiEditJenisTerapis : destinasiNavigasi {
    override val route = "editjenisTerapis"
    override val titleRes = "Edit JenisTerapis"
    const val id_jenis_terapis = "id_jenisTerapis"
    val routeWithArgs = "$route/{$id_jenis_terapis}"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditJenisTerapisView(
    navigateBack: () -> Unit,
    onNavigateUp: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: EditJenisTerapisViewModel = viewModel(factory = PenyediaViewModel.Factory)
){
    val coroutineScope = rememberCoroutineScope()

    Scaffold (
        topBar = {
            CostumeTopAppBar(
                title = DestinasiEditJenisTerapis.titleRes,
                canNavigateBack = true,
                navigateUp = onNavigateUp
            )
        }
    ){ innerPadding ->
        EntryBody(
            insertUiState = viewModel.uiState,
            onSiswaValueChange = viewModel::updateInsertJnsState,
            onSaveClick = {
                coroutineScope.launch {
                    viewModel.editJenisTerapis()
                    navigateBack()
                }
            },
            modifier = modifier
                .padding(innerPadding)
                .offset(y = (-70).dp)
        )

    }
}