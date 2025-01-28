package com.example.uas.ui.view.JenisTerapis

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.finalpam.ui.viewmodel.jenis_terapis.InsertJenisTerapisUiEvent
import com.example.finalpam.ui.viewmodel.jenis_terapis.InsertJenisTerapisUiState
import com.example.finalpam.ui.viewmodel.jenis_terapis.InsertJenisTerapisViewModel
import com.example.uas.ui.customwidget.CostumeTopAppBar
import com.example.uas.ui.navigation.destinasiNavigasi
import com.example.uas.ui.viewmodel.PenyediaViewModel
import kotlinx.coroutines.launch

object DestinasiEntryJenisTerapis: destinasiNavigasi {
    override val route="entryjenis_terapis"
    override val titleRes="Entry JenisTerapis"
}

@OptIn ( ExperimentalMaterial3Api ::class )
@Composable
fun  EntryJnsScreen (
    navigateBack :  ()  ->  Unit,
    modifier : Modifier =  Modifier,
    viewModel : InsertJenisTerapisViewModel =  viewModel ( factory =  PenyediaViewModel .Factory)
) {
    val  coroutineScope  =  rememberCoroutineScope ()

    val  scrollBehavior  =  TopAppBarDefaults . enterAlwaysScrollBehavior ()
    Scaffold (
        modifier =  modifier . nestedScroll ( scrollBehavior .nestedScrollConnection),
        topBar =  {
            CostumeTopAppBar (
                title =  DestinasiEntryJenisTerapis .titleRes,
                canNavigateBack =  true ,
                scrollBehavior =  scrollBehavior ,
                navigateUp =  navigateBack
            )
        }
    )  {  innerPadding  ->
        EntryBody (
            insertUiState =  viewModel .uiState,
            onSiswaValueChange =  viewModel :: updateInsertJnsState,
            onSaveClick =  {
                coroutineScope . launch  {
                    viewModel . insertJns ()
                    navigateBack ()
                }
            },
            modifier =  Modifier
                . padding ( innerPadding )
                . verticalScroll ( rememberScrollState ())
                . fillMaxWidth ()
        )

    }
}

@Composable
fun  EntryBody (
    insertUiState : InsertJenisTerapisUiState,

    onSiswaValueChange :  (InsertJenisTerapisUiEvent)  ->  Unit,
    onSaveClick :  ()  ->  Unit,
    modifier : Modifier =  Modifier
) {
    Column (
        verticalArrangement =  Arrangement . spacedBy ( 18 . dp ),
        modifier =  modifier . padding ( 12 . dp )
    )  {
        FormInput (
            insertUiEvent =  insertUiState .insertJenisTerapisUiEvent,
            onValueChange =  onSiswaValueChange ,
            modifier =  Modifier . fillMaxWidth ()
        )
        Button (
            onClick =  onSaveClick ,
            shape =  MaterialTheme . shapes .small,
            modifier =  Modifier . fillMaxWidth ()
        )  {
            Text ( text =  "Simpan" )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun  FormInput (
    insertUiEvent : InsertJenisTerapisUiEvent,
    modifier : Modifier =  Modifier,
    onValueChange :  (InsertJenisTerapisUiEvent)  ->  Unit  =  {},
    enabled :  Boolean  = true
) {
    Column (
        modifier =  modifier ,

        verticalArrangement =  Arrangement . spacedBy ( 12 . dp )
    )  {
        OutlinedTextField (
            value =  insertUiEvent .id_jenis_terapis,
            onValueChange =  {  onValueChange ( insertUiEvent . copy ( id_jenis_terapis =  it ))  } ,
            label =  {  Text ( "id_jenis_terapis" )  } ,
            modifier =  Modifier . fillMaxWidth (),
            enabled =  enabled ,
            singleLine =  true
        )
        OutlinedTextField (
            value =  insertUiEvent .nama_jenis_terapi,
            onValueChange =  {  onValueChange ( insertUiEvent . copy ( nama_jenis_terapi =  it ))  } ,
            label =  {  Text ( "nama_jenis_terapis" )  } ,
            modifier =  Modifier . fillMaxWidth (),
            enabled =  enabled ,
            singleLine =  true
        )
        OutlinedTextField (
            value =  insertUiEvent .deskripsi_terapi,
            onValueChange =  {  onValueChange ( insertUiEvent . copy ( deskripsi_terapi =  it ))  } ,
            label =  {  Text ( "deskripsi_terapi" )  } ,
            modifier =  Modifier . fillMaxWidth (),
            enabled =  enabled ,
            singleLine =  true
        )
        if  ( enabled ) {
            Text (
                text =  "Isi Semua Data!" ,
                modifier =  Modifier . padding ( 12 . dp )
            )
        }
        Divider (
            thickness =  8 . dp ,
            modifier =  Modifier . padding ( 12 . dp )
        )
    }
}