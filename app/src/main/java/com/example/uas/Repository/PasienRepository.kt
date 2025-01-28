package com.example.uas.Repository



import com.example.uas.model.Pasien
import com.example.uas.service.PasienService
import java.io.IOException

interface PasienRepository {
    suspend fun getPasien(): List<Pasien>
    suspend fun insertPasien(pasien: Pasien)
    suspend fun updatePasien(id_pasien: String, pasien: Pasien)
    suspend fun deletePasien(id_pasien: String)
    suspend fun getPasienById(id_pasien: String): Pasien
}

class NetworkPasienRepository(
    private val pasienApiService: PasienService
) : PasienRepository {
    override suspend fun insertPasien(pasien: Pasien) {
        pasienApiService.insertPasien(pasien)
    }

    override suspend fun updatePasien(id_pasien: String, pasien: Pasien) {
        pasienApiService.updatePasien(id_pasien, pasien)
    }

    override suspend fun deletePasien(id_pasien: String) {
        try {
            val response = pasienApiService.deletePasien(id_pasien)
            if (!response.isSuccessful) {
                throw IOException("Failed to delete pasien. HTTP Status code: ${response.code()}")
            } else {
                response.message()
                println(response.message())
            }
        } catch (e: Exception) {
            throw e
        }
    }

    override suspend fun getPasien(): List<Pasien> = pasienApiService.getAllPasien()

    override suspend fun getPasienById(id_pasien: String): Pasien {
        try {
            return pasienApiService.getPasienById(id_pasien)
        } catch (e: IOException) {
            throw IOException("Failed to fetch pasien with ID: $id_pasien. Network error occurred.", e)
        }
    }
}
