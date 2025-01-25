package com.ujwal.analytics.data.di

import com.ujwal.analytics.data.RoomAnalyticsRepository
import com.ujwal.analytics.domain.AnalyticsRepository
import com.ujwal.core.database.RunDatabase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val analyticsDataModule = module {

    singleOf(::RoomAnalyticsRepository).bind<AnalyticsRepository>()
    single { get<RunDatabase>().analyticsDao }
}