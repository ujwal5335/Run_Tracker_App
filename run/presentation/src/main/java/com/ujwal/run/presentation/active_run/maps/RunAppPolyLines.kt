package com.ujwal.run.presentation.active_run.maps

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.google.android.gms.maps.model.JointType
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.Polyline
import com.ujwal.core.domain.location.LocationTimeStamp

@Composable
fun RunAppPolyLines(locations: List<List<LocationTimeStamp>>) {
    val polyLines = remember(locations) {
        locations.map {
            it.zipWithNext { timeStamp1, timeStamp2 ->
                PolyLineUi(
                    location1 = timeStamp1.location.location,
                    location2 = timeStamp2.location.location,
                    color = PolyLineColorCalculator.locationsToColor(
                        location1 = timeStamp1,
                        location2 = timeStamp2
                    )
                )
            }
        }
    }
    polyLines.forEach { polyLine ->
        polyLine.forEach { polyLineUi ->
            Polyline(
                points = listOf(
                    LatLng(polyLineUi.location1.latitude, polyLineUi.location1.longitude),
                    LatLng(polyLineUi.location2.latitude, polyLineUi.location2.longitude)
                ),
                color = polyLineUi.color,
                jointType = JointType.BEVEL,
            )
        }
    }
}