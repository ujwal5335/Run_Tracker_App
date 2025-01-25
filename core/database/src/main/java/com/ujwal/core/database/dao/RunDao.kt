package com.ujwal.core.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.ujwal.core.database.entity.RunEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RunDao {

    @Upsert
    suspend fun upsertRun(run: RunEntity)

    @Upsert
    suspend fun upsertRuns(runs: List<RunEntity>)

    // If the function returns a Flow, it doesn't need to be suspending,
    // since it doesn't do anything by default, unless you collect it
    // (which has to happen in a coroutine)
    @Query("SELECT * FROM RunEntity ORDER BY dateTimeUtc DESC")
    fun getRuns(): Flow<List<RunEntity>>

    @Query("DELETE FROM RunEntity WHERE id=:id")
    suspend fun deleteRun(id: String)

    @Query("DELETE FROM RunEntity")
    suspend fun deleteAllRuns()
}
