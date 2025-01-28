package com.example.uas.Repository

import com.example.uas.model.Terapis
import com.example.uas.service.TerapisService

import java.io.IOException

interface TerapiRepository {
    suspend fun getTerapi(): List<Terapis>
    suspend fun insertTerapi(terapi: Terapis)
    suspend fun updateTerapi(id_terapi: String, terapi: Terapis)
    suspend fun deleteTerapi(id_terapi: String)
    suspend fun getTerapiById(id_terapi: String): Terapis
}

class NetworkTerapiRepository(
    private val terapiApiService: TerapisService
) : TerapiRepository {
    override suspend fun insertTerapi(terapis: Terapis) {
        terapiApiService.insertTerapis(terapis)
    }

    override suspend fun updateTerapi(id_terapis: String, terapi: Terapis) {
        terapiApiService.updateTerapis(id_terapis, terapi)
    }

    override suspend fun deleteTerapi(id_terapis: String) {
        try {
            val response = terapiApiService.deleteTerapis(id_terapis)
            if (!response.isSuccessful) {
                throw IOException("Failed to delete terapi. HTTP Status code: ${response.code()}")
            } else {
                response.message()
                println(response.message())
            }
        } catch (e: Exception) {
            throw e
        }
    }

    override suspend fun getTerapi(): List<Terapis> = terapiApiService.getAllTerapis()

    override suspend fun getTerapiById(id_terapis: String): Terapis {
        try {
            return terapiApiService.getTerapisById(id_terapis)
        } catch (e: IOException) {
            throw IOException("Failed to fetch terapi with ID: $id_terapis. Network error occurred.", e)
        }
    }
}
