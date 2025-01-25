package com.ujwal.core.data.di

import com.ujwal.core.data.auth.EncryptedSessionStorage
import com.ujwal.core.data.networking.HttpClientFactory
import com.ujwal.core.data.run.OfflineFirstRunRepository
import com.ujwal.core.domain.SessionStorage
import com.ujwal.core.domain.run.RunRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val coreDataModule = module {

    single {
        HttpClientFactory(get()).build()
    }

    singleOf(::EncryptedSessionStorage).bind<SessionStorage>()

    singleOf(::OfflineFirstRunRepository).bind<RunRepository>()
}