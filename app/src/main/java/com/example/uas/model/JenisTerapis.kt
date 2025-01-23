package com.example.uas.model

import kotlinx.serialization.Serializable

@Serializable
data class JenisTerapis(

    val id_jenis_terapis: String,
    val nama_jenis_terapi: String,
    val deskripsi_terapis: String,
)
