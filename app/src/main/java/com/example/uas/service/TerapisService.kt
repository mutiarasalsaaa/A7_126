package com.example.uas.service

import com.example.uas.model.Terapis
import retrofit2.Response
import retrofit2.http.*

interface TerapisService {

    @Headers(
        "Accept: application/json",
        "Content-Type: application/json"
    )
    @GET("getTerapis.php")
    suspend fun getAllTerapis(): List<Terapis>

    @GET("getTerapisById.php/{id_terapis}")
    suspend fun getTerapisById(
        @Path("id_terapis") idTerapis: Int
    ): Terapis

    @POST("insertTerapis.php")
    suspend fun insertTerapis(
        @Body terapis: Terapis
    ): Response<Void>

    @PUT("editTerapis.php/{id_terapis}")
    suspend fun updateTerapis(
        @Path("id_terapis") idTerapis: Int,
        @Body terapis: Terapis
    ): Response<Void>

    @DELETE("deleteTerapis.php/{id_terapis}")
    suspend fun deleteTerapis(
        @Path("id_terapis") idTerapis: Int
    ): Response<Void>
}
