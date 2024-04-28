package org.d3if3056.testing.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import org.d3if3056.testing.model.Mahasiswa
import kotlinx.coroutines.flow.Flow

@Dao
interface MahasiswaDao {
    @Insert
    suspend fun insert(mahasiswa: Mahasiswa)

    @Update
    suspend fun update(mahasiswa: Mahasiswa)

    @Query("SELECT * FROM mahasiswa ORDER BY kelas ASC, nim ASC")
    fun getMahasiswa() : Flow<List<Mahasiswa>>

    @Query("SELECT * FROM mahasiswa WHERE id = :id")
    suspend fun getMahasiswaById(id: Long): Mahasiswa?

    @Query("DELETE FROM mahasiswa WHERE id = :id")
    suspend fun deleteById(id: Long)
}