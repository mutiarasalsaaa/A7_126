package com.example.uas.Repository


import com.example.uas.model.JenisTerapis
import com.example.uas.service.JenisTerapisService
import java.io.IOException

interface JenisTerapisRepository {
    suspend fun getJenisTerapis(): List<JenisTerapis>
    suspend fun insertJenisTerapis(jenisTerapis: JenisTerapis)
    suspend fun updateJenisTerapis(id_jenis: String, jenisTerapis: JenisTerapis)
    suspend fun deleteJenisTerapis(id_jenis: String)
    suspend fun getJenisTerapisById(id_jenis: String): JenisTerapis
}

class NetworkJenisTerapisRepository(
    private val jenisTerapisApiService: JenisTerapisService
) : JenisTerapisRepository {
    override suspend fun insertJenisTerapis(jenisTerapis: JenisTerapis) {
        jenisTerapisApiService.insertJenisTerapis(jenisTerapis)
    }

    override suspend fun updateJenisTerapis(id_jenis: String, jenisTerapis: JenisTerapis) {
        jenisTerapisApiService.updateJenisTerapis(id_jenis, jenisTerapis)
    }

    override suspend fun deleteJenisTerapis(id_jenis: String) {
        try {
            val response = jenisTerapisApiService.deleteJenisTerapis(id_jenis)
            if (!response.isSuccessful) {
                throw IOException("Failed to delete jenis terapis. HTTP Status code: ${response.code()}")
            } else {
                response.message()
                println(response.message())
            }
        } catch (e: Exception) {
            throw e
        }
    }

    override suspend fun getJenisTerapis(): List<JenisTerapis> = jenisTerapisApiService.getJenisTerapis()

    override suspend fun getJenisTerapisById(id_jenis: String): JenisTerapis {
        try {
            return jenisTerapisApiService.getJenisTerapisById(id_jenis)
        } catch (e: IOException) {
            throw IOException("Failed to fetch jenis terapis with ID: $id_jenis. Network error occurred.", e)
        }
    }
}
