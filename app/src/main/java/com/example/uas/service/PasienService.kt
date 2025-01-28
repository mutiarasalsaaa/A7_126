package com.example.uas.service

import com.example.uas.model.Pasien
import retrofit2.Response
import retrofit2.http.*

interface PasienService {
    @GET("pasien")
    suspend fun getAllPasien(): List<Pasien>

    @GET("pasien/{id}")
    suspend fun getPasienById(@Path("id") id: String): Pasien

    @POST("pasien")
    suspend fun insertPasien(@Body pasien: Pasien)

    @PUT("pasien/{id}")
    suspend fun updatePasien(@Path("id") id: String, @Body pasien: Pasien)

    @DELETE("pasien/{id}")
    suspend fun deletePasien(@Path("id") id: String): Response<Unit>
}
