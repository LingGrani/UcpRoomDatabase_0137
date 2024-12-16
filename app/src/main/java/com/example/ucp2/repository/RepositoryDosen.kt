package com.example.ucp2.repository

import com.example.ucp2.data.entity.Dosen
import kotlinx.coroutines.flow.Flow

interface RepositoryDosen {
    fun getAllDosen(): Flow<List<Dosen>>
    suspend fun insertDosen(dosen: Dosen)
    fun getDosen(nidn: String): Flow<Dosen>
    suspend fun deleteDosen(dosen: Dosen)
    suspend fun updateDosen(dosen: Dosen)
}