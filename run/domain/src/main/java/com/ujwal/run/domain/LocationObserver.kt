package com.ujwal.run.domain

import com.ujwal.core.domain.location.LocationWithAltitude
import kotlinx.coroutines.flow.Flow

interface LocationObserver {

    fun observeLocation(interval: Long): Flow<LocationWithAltitude>
}