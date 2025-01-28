package com.example.uas.dependenciesinjection


import com.example.uas.Repository.JenisTerapisRepository
import com.example.uas.Repository.NetworkJenisTerapisRepository
import com.example.uas.Repository.NetworkPasienRepository
import com.example.uas.Repository.PasienRepository
import com.example.uas.service.JenisTerapisService
import com.example.uas.service.PasienService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val jenisTerapisRepository: JenisTerapisRepository
//    val kursusRepository: KursusRepository
//    val instrukturRepository: InstrukturRepository
//    val pendaftaranRepository: PendaftaranRepository
}

class reflexyContainer : AppContainer {
    private val baseUrl = "http://192.168.58.119/PAMakhir/"
    private val json = Json { ignoreUnknownKeys = true }
    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl).build()

    private val jenisTerapisService: JenisTerapisService by lazy { retrofit.create(JenisTerapisService::class.java) }
    override val jenisTerapisRepository: JenisTerapisRepository by lazy { NetworkJenisTerapisRepository(jenisTerapisService) }


}