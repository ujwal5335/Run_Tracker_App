package com.ujwal.auth.data.di

import com.ujwal.auth.data.AuthRepositoryImpl
import com.ujwal.auth.data.EmailPatternValidator
import com.ujwal.auth.domain.AuthRepository
import com.ujwal.auth.domain.PatternValidator
import com.ujwal.auth.domain.UserDataValidator
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val authDataModule = module {
    single<PatternValidator> {
        EmailPatternValidator
    }
    singleOf(::UserDataValidator)
    singleOf(::AuthRepositoryImpl).bind<AuthRepository>()
}