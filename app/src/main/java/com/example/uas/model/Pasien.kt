package com.example.uas.model

import kotlinx.serialization.Serializable

@Serializable
data class Pasien(

    val id_pasien: String,
    val nama_pasien: String,
    val alamat: String,
    val nomor_hp: String,
    val tgl_lahir: String,
    val riwayat_medikal: String
)
