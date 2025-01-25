package com.example.uas.ui.view.JenisTerapis

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.uas.ui.customwidget.CostumeTopAppBar
import com.example.uas.ui.viewmodel.JenisTerapis.DetailJenisTerapisUiState
import com.example.uas.ui.viewmodel.JenisTerapis.DetailJenisTerapisViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailJenisTerapisView(
    navigateBack: () -> Unit,
    viewModel: DetailJenisTerapisViewModel = viewModel()
) {
    val uiState by viewModel.detailJenisTerapisUiState.collectAsState()

    Scaffold(
        topBar = {
            CostumeTopAppBar(
                title = "Detail Jenis Terapis",
                canNavigateBack = true,
                navigateUp = navigateBack
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
    