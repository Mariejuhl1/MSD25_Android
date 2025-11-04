package com.example.msd25_android.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
    primary = ButtonNavGreen,      // main accent (nav bar, buttons)
    onPrimary = DarkForest,        // text/icons on top of primary
    background = PaleMint,         // app background
    surface = PaleMint,
    onBackground = DarkForest,
    onSurface = DarkForest,
)

private val DarkColorScheme = darkColorScheme(
    primary = ButtonNavGreen,
    onPrimary = PaleMint,
    background = DarkForest,
    surface = DarkForest,
    onBackground = PaleMint,
    onSurface = PaleMint,
)

@Composable
fun MSD25_AndroidTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
