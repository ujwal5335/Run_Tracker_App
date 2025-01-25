package com.ujwal.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ujwal.core.database.dao.AnalyticsDao
import com.ujwal.core.database.dao.RunDao
import com.ujwal.core.database.dao.RunPendingSyncDao
import com.ujwal.core.database.entity.DeletedRunSyncEntity
import com.ujwal.core.database.entity.RunEntity
import com.ujwal.core.database.entity.RunPendingSyncEntity

@Database(
    entities = [RunEntity::class, RunPendingSyncEntity::class, DeletedRunSyncEntity::class],
    version = 1
)
abstract class RunDatabase : RoomDatabase() {

    abstract val runDao: RunDao
    abstract val runPendingSyncDao: RunPendingSyncDao
    abstract val analyticsDao: AnalyticsDao
}