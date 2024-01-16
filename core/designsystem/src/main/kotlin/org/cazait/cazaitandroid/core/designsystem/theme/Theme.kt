package org.cazait.cazaitandroid.core.designsystem.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFD17B49), // Darker shade of SunsetOrange
    onPrimary = White, // Black for contrast on primary
    primaryContainer = Color(0xFF2C2C2C), // Dark gray for primary container
    onPrimaryContainer = Color(0xFFFFFFFF), // White on primary container
    inversePrimary = Color(0xFF39A2DB), // Inverse of Neon01, considering readability
    secondary = Gray06, // Same as Green04, or a darker shade for dark theme
    onSecondary = White, // White for contrast on secondary
    secondaryContainer = Color(0xFF1B5E20), // Darker shade of Green01
    onSecondaryContainer = Color(0xFF4CAF50), // Green04 for contrast on secondary container
    tertiary = Color(0xFFFFEB3B), // Same as Yellow01, or a darker shade for dark theme
    onTertiary = Color(0xFF000000), // Black for contrast on tertiary
    tertiaryContainer = Color(0xFFF9A825), // Darker shade of Yellow03A40
    onTertiaryContainer = Color(0xFFFFEB3B), // Yellow04 for contrast on tertiary container
    error = Color(0xFFD32F2F), // Same as Red03, or a darker shade for dark theme
    onError = Color(0xFFFFFFFF), // White for contrast on error
    errorContainer = Color(0xFFB71C1C), // Darker shade of Red01
    onErrorContainer = Color(0xFFF44336), // Red06 for contrast on error container
    surface = Gray07, // Darker shade for surface
    onSurface = Color(0xFFFFFFFF), // White for contrast on surface
    inverseSurface = Color(0xFF3E2723), // Darker shade of Yellow05
    inverseOnSurface = Color(0xFFFFFFFF), // White for contrast on inverse surface
    outline = Color(0xFFBDBDBD), // Lighter shade of LightGray
    outlineVariant = Color(0xFF757575), // Same as DarkGray, or adjust for visibility
    scrim = Color(0xFF121212), // Dark shade for scrim
    background = Gray08,
)

private val LightColorScheme = lightColorScheme(
    primary = SunsetOrange,
    onPrimary = White,
    primaryContainer = White,
    onPrimaryContainer = Black,
    inversePrimary = Neon01,
    secondary = Black,
    onSecondary = White,
    secondaryContainer = Green01,
    onSecondaryContainer = Green04,
    tertiary = Yellow01,
    onTertiary = Black,
    tertiaryContainer = Yellow03A40,
    onTertiaryContainer = Yellow04,
    error = Red03,
    onError = White,
    errorContainer = Red01,
    onErrorContainer = Red06,
    surface = Black,
    onSurface = White,
    inverseSurface = Yellow05,
    inverseOnSurface = White,
    outline = LightGray,
    outlineVariant = Gray04,
    scrim = White,
    background = Beige,
)

val LocalDarkTheme = compositionLocalOf { true }

val ColorScheme.surfaceDim
    @Composable
    get() = if (LocalDarkTheme.current) Black else PaleGray

@Composable
fun CazaitTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    if (!LocalInspectionMode.current) {
        val view = LocalView.current
        SideEffect {
            val window = (view.context as Activity).window
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
            WindowCompat.getInsetsController(window, view).isAppearanceLightNavigationBars =
                !darkTheme
        }
    }

    CompositionLocalProvider(
        LocalDarkTheme provides darkTheme,
        LocalTypography provides Typography,
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            content = content,
        )
    }
}

object CazaitTheme {
    val typography: CazaitTypography
        @Composable
        get() = LocalTypography.current
}
