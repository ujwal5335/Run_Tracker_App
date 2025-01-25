package com.ujwal.auth.presentation.register

import com.ujwal.core.presentation.ui.UiText

sealed interface RegisterEvent {

    data object RegistrationSuccess : RegisterEvent
    data class Error(val error: UiText) : RegisterEvent
}