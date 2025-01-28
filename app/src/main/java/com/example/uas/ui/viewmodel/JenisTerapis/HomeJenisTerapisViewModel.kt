package com.example.finalpam.ui.viewmodel.jenisTerapis

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.network.HttpException
import com.example.uas.Repository.JenisTerapisRepository
import com.example.uas.model.JenisTerapis
import kotlinx.coroutines.launch
import java.io.IOException

sealed class  HomeJenisTerapisUiState  {
    data class  Success ( val  jenisTerapis :  List <JenisTerapis> )  :  HomeJenisTerapisUiState ()
    object  Error  :  HomeJenisTerapisUiState ()
    object  Loading  :  HomeJenisTerapisUiState ()
}

class  HomeJenisTerapisViewModel(private val jns: JenisTerapisRepository)  :  ViewModel() {
    var  jnsUIState :  HomeJenisTerapisUiState  by  mutableStateOf ( HomeJenisTerapisUiState . Loading )
        private set

    init  {
        getJns ()
    }

    fun  getJns () {
        viewModelScope . launch  {
            jnsUIState  =  HomeJenisTerapisUiState . Loading
            jnsUIState  = try  {
                HomeJenisTerapisUiState . Success (jns. getJenisTerapis ())
            }  catch  (e : IOException) {
                HomeJenisTerapisUiState . Error
            }  catch  (e : HttpException) {
                HomeJenisTerapisUiState . Error
            }
        }
    }


    fun  deleteJns ( id_jenis_terapis :  String ) {
        viewModelScope . launch  {
            try  {
                jns. deleteJenisTerapis ( id_jenis_terapis )
            }  catch  (e : IOException){
                HomeJenisTerapisUiState . Error
            }  catch  (e : HttpException){
                HomeJenisTerapisUiState . Error
            }
        }
    }
}