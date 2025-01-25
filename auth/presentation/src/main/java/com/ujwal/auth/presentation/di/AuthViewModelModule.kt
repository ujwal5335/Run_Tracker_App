package com.ujwal.auth.presentation.di

import com.ujwal.auth.presentation.login.LoginViewModel
import com.ujwal.auth.presentation.register.RegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val authViewModelModule = module {
    viewModelOf(::RegisterViewModel)
    viewModelOf(::LoginViewModel)
}