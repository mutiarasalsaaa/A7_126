package com.example.uas.service

import com.example.uas.model.Pasien
import retrofit2.Response
import retrofit2.http.*

interface PasienService {

    @Headers(
        "Accept: application/json",
        "Content-Type: application/json"
    )
    @GET("getPasien.php")
    suspend fun getAllPasien(): List<Pasien>

    @GET("getPasienById.php/{id_pasien}")
    suspend fun getPasienById(
        @Path("id_pasien") idPasien: Int
    ): Pasien

    @POST("insertPasien.php")
    suspend fun insertPasien(
        @Body pasien: Pasien
    ): Response<Void>

    @PUT("editPasien.php/{id_pasien}")
    suspend fun updatePasien(
        @Path("id_pasien") idPasien: Int,
        @Body pasien: Pasien
    ): Response<Void>

    @DELETE("deletePasien.php/{id_pasien}")
    suspend fun deletePasien(
        @Path("id_pasien") idPasien: Int
    ): Response<Void>
}
