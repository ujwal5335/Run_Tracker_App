package com.ujwal.run.location

import android.location.Location
import com.ujwal.core.domain.location.LocationWithAltitude

fun Location.toLocationWithAltitude(): LocationWithAltitude {
    return LocationWithAltitude(
        location = com.ujwal.core.domain.location.Location(
            latitude = latitude,
            longitude = longitude
        ),
        altitude = altitude
    )
}