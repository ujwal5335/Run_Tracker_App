package com.ujwal.run.presentation.run_overview.mapper

import com.ujwal.core.domain.run.Run
import com.ujwal.core.presentation.ui.formatted
import com.ujwal.core.presentation.ui.toFormattedKm
import com.ujwal.core.presentation.ui.toFormattedKmh
import com.ujwal.core.presentation.ui.toFormattedMeters
import com.ujwal.core.presentation.ui.toFormattedPace
import com.ujwal.run.presentation.run_overview.model.RunUi
import java.time.ZoneId
import java.time.format.DateTimeFormatter

// Convert the UTC time to user time zone.

fun Run.toRunUi(): RunUi {
    val dateTimeLocalTime = dateTimeUtc
        .withZoneSameInstant(ZoneId.systemDefault())
    val formattedDateTime = DateTimeFormatter
        .ofPattern("MMM dd, yyyy - hh:mm a")
        .format(dateTimeLocalTime)

    val distanceKm = distanceMeters / 1000.0

    return RunUi(
        id = id!!,
        duration = duration.formatted(),
        dateTime = formattedDateTime,
        distance = distanceKm.toFormattedKm(),
        avgSpeed = avgSpeedKmh.toFormattedKmh(),
        maxSpeed = maxSpeedKmh.toFormattedKmh(),
        pace = duration.toFormattedPace(distanceKm),
        totalElevation = totalElevationMeters.toFormattedMeters(),
        mapPictureUrl = mapPictureUrl
    )
}