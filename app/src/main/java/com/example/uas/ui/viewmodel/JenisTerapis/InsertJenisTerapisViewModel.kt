package com.example.finalpam.ui.viewmodel.jenis_terapis

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.uas.Repository.JenisTerapisRepository
import com.example.uas.model.JenisTerapis
import kotlinx.coroutines.launch

class  InsertJenisTerapisViewModel(private val jns: JenisTerapisRepository)  :  ViewModel() {
    var  uiState  by  mutableStateOf ( InsertJenisTerapisUiState ())
        private set

    fun  updateInsertJnsState ( insertJenisTerapisUiEvent :  InsertJenisTerapisUiEvent ) {
        uiState  =  InsertJenisTerapisUiState ( insertJenisTerapisUiEvent =  insertJenisTerapisUiEvent )
    }

    suspend fun  insertJns () {
        viewModelScope . launch  {
            try  {
                jns. insertJenisTerapis (uiState.insertJenisTerapisUiEvent. toJns ())
            } catch  (e : Exception ){
                e. printStackTrace ()
            }
        }
    }
}


data class  InsertJenisTerapisUiState (
    val  insertJenisTerapisUiEvent :  InsertJenisTerapisUiEvent  =  InsertJenisTerapisUiEvent ()
)

data class  InsertJenisTerapisUiEvent (
    val  id_jenis_terapis :  String  =  "" ,
    val  nama_jenis_terapi :  String  =  "" ,
    val  deskripsi_terapi :  String  =  "" ,
)

fun  InsertJenisTerapisUiEvent . toJns () : JenisTerapis =  JenisTerapis (
    id_jenis_terapis =  id_jenis_terapis,
    nama_jenis_terapi =  nama_jenis_terapi,
    deskripsi_terapi =  deskripsi_terapi
)

fun JenisTerapis. toUiStateJns () :  InsertJenisTerapisUiState  =  InsertJenisTerapisUiState (
    insertJenisTerapisUiEvent =  toInsertJenisTerapisUiEvent ()
)

fun JenisTerapis. toInsertJenisTerapisUiEvent () :  InsertJenisTerapisUiEvent  =  InsertJenisTerapisUiEvent (
    id_jenis_terapis =  id_jenis_terapis,
    nama_jenis_terapi =  nama_jenis_terapi,
    deskripsi_terapi =  deskripsi_terapi
)