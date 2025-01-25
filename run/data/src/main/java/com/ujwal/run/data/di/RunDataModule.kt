package com.ujwal.run.data.di

import com.ujwal.core.domain.SyncRunScheduler
import com.ujwal.run.data.CreateRunWorker
import com.ujwal.run.data.DeleteRunWorker
import com.ujwal.run.data.FetchRunsWorker
import com.ujwal.run.data.SyncRunWorkerScheduler
import org.koin.androidx.workmanager.dsl.workerOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val runDataModule = module {

    workerOf(::CreateRunWorker)
    workerOf(::DeleteRunWorker)
    workerOf(::FetchRunsWorker)

    singleOf(::SyncRunWorkerScheduler).bind<SyncRunScheduler>()
}