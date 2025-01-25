package com.ujwal.auth.presentation.login

import com.ujwal.core.presentation.ui.UiText

sealed interface LoginEvent {

    data class Error(val error: UiText) : LoginEvent
    data object LoginSuccess : LoginEvent
}