package com.ujwal.analytics.presentation

sealed interface AnalyticsAction {
    data object OnBackClick: AnalyticsAction
}