package com.example.uas.model

import kotlinx.serialization.Serializable

@Serializable
data class Terapis(

    val id_terapis: String,

    val nama_terapis: String,
    val spealisasi: String,
    val no_izinPraktik: String
)
