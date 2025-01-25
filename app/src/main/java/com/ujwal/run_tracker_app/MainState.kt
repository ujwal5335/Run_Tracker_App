package com.ujwal.run_tracker_app

data class MainState(
    val isLoggedIn: Boolean = false,
    val isCheckingAuth: Boolean = false,
    val showAnalyticsInstallDialog: Boolean = false
)
