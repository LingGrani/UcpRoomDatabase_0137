package com.example.ucp2.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.ucp2.data.entity.Dosen
import kotlinx.coroutines.flow.Flow

@Dao
interface DosenDao {
    @Query("SELECT * FROM dosen ORDER BY nama ASC")
    fun getAllDosen(): Flow<List<Dosen>>
    @Insert
    suspend fun insertDosen(
        dosen: Dosen
    )
    @Query("SELECT COUNT(*) > 0 FROM dosen WHERE nidn = :nidn")
    fun checkNidnExists(nidn: String): Boolean
}