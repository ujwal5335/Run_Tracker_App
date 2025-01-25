package com.ujwal.run.presentation.active_run

import com.ujwal.core.presentation.ui.UiText

sealed interface ActiveRunEvent {

    data class Error(val error: UiText) : ActiveRunEvent

    data object RunSaved : ActiveRunEvent
}