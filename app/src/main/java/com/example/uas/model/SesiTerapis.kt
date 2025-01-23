package com.example.uas.model

import kotlinx.serialization.Serializable


@Serializable
data class SesiTerapis(
    val id_sesi: String,
    val id_pasien: String,
    val id_terapis: String,
    val tgl_sesi: String
)
