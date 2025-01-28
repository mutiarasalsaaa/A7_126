package com.example.uas.ui.viewmodel

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.finalpam.ui.viewmodel.jenisTerapi.EditJenisTerapisViewModel
import com.example.finalpam.ui.viewmodel.jenisTerapis.HomeJenisTerapisViewModel
import com.example.finalpam.ui.viewmodel.jenis_terapis.InsertJenisTerapisViewModel
import com.example.uas.TerapiApplications
import com.example.uas.ui.viewmodel.JenisTerapis.DetailJenisTerapisViewModel

object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer { HomeJenisTerapisViewModel(reflexyApp().container.jenisTerapisRepository) }
        initializer { InsertJenisTerapisViewModel(reflexyApp().container.jenisTerapisRepository) }
        initializer { DetailJenisTerapisViewModel(createSavedStateHandle(), jenisterapiRepository = reflexyApp().container.jenisTerapisRepository) }
        initializer { EditJenisTerapisViewModel(createSavedStateHandle(), jenisTerapiRepository = reflexyApp().container.jenisTerapisRepository) }
    }
}

fun CreationExtras.reflexyApp(): TerapiApplications=
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as TerapiApplications)