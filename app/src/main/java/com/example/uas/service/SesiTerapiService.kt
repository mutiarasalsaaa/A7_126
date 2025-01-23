package com.example.uas.service


import com.example.uas.model.SesiTerapis
import retrofit2.Response
import retrofit2.http.*

interface SesiTerapiService {

    @Headers(
        "Accept: application/json",
        "Content-Type: application/json"
    )
    @GET("getSesiTerapi.php")
    suspend fun getAllSesiTerapi(): List<SesiTerapis>

    @GET("getSesiTerapiById.php/{id_sesi}")
    suspend fun getSesiTerapiById(
        @Path("id_sesi") idSesi: Int
    ): SesiTerapis

    @POST("insertSesiTerapi.php")
    suspend fun insertSesiTerapi(
        @Body sesiTerapi: SesiTerapis
    ): Response<Void>

    @PUT("editSesiTerapi.php/{id_sesi}")
    suspend fun updateSesiTerapi(
        @Path("id_sesi") idSesi: Int,
        @Body sesiTerapi: SesiTerapis
    ): Response<Void>

    @DELETE("deleteSesiTerapi.php/{id_sesi}")
    suspend fun deleteSesiTerapi(
        @Path("id_sesi") idSesi: Int
    ): Response<Void>
}
