package com.ujwal.core.domain.location

import kotlin.time.Duration

data class LocationTimeStamp(
    val location: LocationWithAltitude,
    val durationTimeStamp: Duration
)
