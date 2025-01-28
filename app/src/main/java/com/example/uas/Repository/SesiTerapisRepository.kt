package com.example.uas.Repository


import com.example.uas.model.SesiTerapis
import com.example.uas.service.SesiTerapiService
import java.io.IOException

interface SesiTerapisRepository {
    suspend fun getSesiTerapis(): List<SesiTerapis>
    suspend fun insertSesiTerapis(sesiTerapis: SesiTerapis)
    suspend fun updateSesiTerapis(id_sesi: String, sesiTerapis: SesiTerapis)
    suspend fun deleteSesiTerapis(id_sesi: String)
    suspend fun getSesiTerapisById(id_sesi: String): SesiTerapis
}

class NetworkSesiTerapisRepository(
    private val sesiTerapisApiService: SesiTerapiService
) : SesiTerapisRepository {
    override suspend fun insertSesiTerapis(sesiTerapis: SesiTerapis) {
        sesiTerapisApiService.insertSesiTerapi(sesiTerapis)
    }

    override suspend fun updateSesiTerapis(id_sesi: String, sesiTerapis: SesiTerapis) {
        sesiTerapisApiService.updateSesiTerapi(id_sesi, sesiTerapis)
    }

    override suspend fun deleteSesiTerapis(id_sesi: String) {
        try {
            val response = sesiTerapisApiService.deleteSesiTerapi(id_sesi)
            if (!response.isSuccessful) {
                throw IOException("Failed to delete sesi terapis. HTTP Status code: ${response.code()}")
            } else {
                response.message()
                println(response.message())
            }
        } catch (e: Exception) {
            throw e
        }
    }

    override suspend fun getSesiTerapis(): List<SesiTerapis> = sesiTerapisApiService.getAllSesiTerapi()

    override suspend fun getSesiTerapisById(id_sesi: String): SesiTerapis {
        try {
            return sesiTerapisApiService.getSesiTerapiById(id_sesi)
        } catch (e: IOException) {
            throw IOException("Failed to fetch sesi terapis with ID: $id_sesi. Network error occurred.", e)
        }
    }
}
