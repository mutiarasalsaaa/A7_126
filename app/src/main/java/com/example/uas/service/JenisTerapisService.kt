package com.example.uas.service

import com.example.uas.model.JenisTerapis
import retrofit2.Response
import retrofit2.http.*

interface JenisTerapisService {
    @Headers(
        "Accept: application/json",
        "Content-Type: application/json"
    )
    @GET("getJenisTerapis.php")
    suspend fun getJenisTerapis(): List<JenisTerapis>

    @GET("getbyJenisTerapis.php/{id_jenis_terapis}")
    suspend fun getJenisTerapisById(@Query("id_jenis_terapis") id_jenis_terapis: String): JenisTerapis

    @POST("insertJenisTerapis.php")
    suspend fun insertJenisTerapis(@Body jenisTerapis: JenisTerapis)

    @PUT("editJenisTerapis.php/{id_jenis_terapis}")
    suspend fun updateJenisTerapis(
        @Query("id_jenis_terapis") id_jenis_terapis: String,
        @Body jenisTerapis: JenisTerapis
    )

    @DELETE("deleteJenisTerapis.php/{id_jenis_terapis}")
    suspend fun deleteJenisTerapis(@Query("id_jenis_terapis") id_jenis_terapis: String): Response<Void>
}