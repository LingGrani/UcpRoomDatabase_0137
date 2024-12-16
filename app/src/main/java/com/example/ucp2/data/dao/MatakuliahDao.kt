package com.example.ucp2.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.ucp2.data.entity.Matakuliah
import kotlinx.coroutines.flow.Flow

@Dao
interface MatakuliahDao {
    @Query("SELECT * FROM matakuliah ORDER BY nama ASC")
    fun getAllMatakuliah(): Flow<List<Matakuliah>>
    @Insert
    suspend fun insertMatakuliah(
        matakuliah: Matakuliah
    )
    @Query("SELECT * FROM matakuliah WHERE kode = :kode")
    fun getMatakuliah(kode: String): Flow<Matakuliah>
    @Delete
    suspend fun deleteMatakuliah(
        matakuliah: Matakuliah
    )
    @Update
    suspend fun updateMatakuliah(
        matakuliah: Matakuliah
    )
}