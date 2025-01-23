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
    suspend fun getJenisTerapisById(
        @Path("id_jenis_terapis") idJenisTerapis: Int
    ): JenisTerapis

    @POST("insertJenisTerapis.php")
    suspend fun insertJenisTerapis(
        @Body jenisTerapis: JenisTerapis
    ): Response<Void>

    @PUT("editJenisTerapis.php/{id_jenis_terapis}")
    suspend fun updateJenisTerapis(
        @Path("id_jenis_terapis") idJenisTerapis: Int,
        @Body jenisTerapis: JenisTerapis
    ): Response<Void>

    @DELETE("deleteJenisTerapis.php/{id_jenis_terapis}")
    suspend fun deleteJenisTerapis(
        @Path("id_jenis_terapis") idJenisTerapis: Int
    ): Response<Void>
}
