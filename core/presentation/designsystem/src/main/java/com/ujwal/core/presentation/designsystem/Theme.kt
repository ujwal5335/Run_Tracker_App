package com.ujwal.core.presentation.designsystem

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

val DarkColorScheme = darkColorScheme(
    primary = RunTrackerAppGreen,
    background = RunTrackerAppBlack,
    surface = RunTrackerAppDarkGray,
    secondary = RunTrackerAppWhite,
    tertiary = RunTrackerAppWhite,
    primaryContainer = RunTrackerAppGreen30,
    onPrimary = RunTrackerAppBlack,
    onBackground = RunTrackerAppWhite,
    onSurface = RunTrackerAppWhite,
    onSurfaceVariant = RunTrackerAppGray,
    error = RunTrackerAppDarkRed,
    errorContainer = RunTrackerAppDarkRed5
)

@Composable
fun RunTrackerAppTheme(
    content: @Composable () -> Unit
) {
    val colorScheme = DarkColorScheme
    val view = LocalView.current
    if (!view.isInEditMode){
        SideEffect {
            val window = (view.context as Activity).window
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = false
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}