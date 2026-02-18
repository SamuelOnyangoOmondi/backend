package com.farmtopalm.terminal.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp

private val Primary = Color(0xFF1976D2)
private val OnPrimary = Color.White
private val Surface = Color(0xFFFAFAFA)
private val OnSurface = Color(0xFF1C1B1F)

private val DarkColorScheme = darkColorScheme(primary = Primary, onPrimary = OnPrimary, surface = Color(0xFF1C1B1F), onSurface = Color.White)
private val LightColorScheme = lightColorScheme(primary = Primary, onPrimary = OnPrimary, surface = Surface, onSurface = OnSurface)

/** Extra-large typography for terminal/kiosk use — easy to read at a glance. */
private val FarmToPalmTypography = Typography(
    displayLarge = TextStyle(fontFamily = FontFamily.Default, fontSize = 52.sp),
    displayMedium = TextStyle(fontFamily = FontFamily.Default, fontSize = 44.sp),
    displaySmall = TextStyle(fontFamily = FontFamily.Default, fontSize = 38.sp),
    headlineLarge = TextStyle(fontFamily = FontFamily.Default, fontSize = 40.sp),
    headlineMedium = TextStyle(fontFamily = FontFamily.Default, fontSize = 34.sp),
    headlineSmall = TextStyle(fontFamily = FontFamily.Default, fontSize = 30.sp),
    titleLarge = TextStyle(fontFamily = FontFamily.Default, fontSize = 30.sp),
    titleMedium = TextStyle(fontFamily = FontFamily.Default, fontSize = 26.sp),
    titleSmall = TextStyle(fontFamily = FontFamily.Default, fontSize = 24.sp),
    bodyLarge = TextStyle(fontFamily = FontFamily.Default, fontSize = 26.sp),
    bodyMedium = TextStyle(fontFamily = FontFamily.Default, fontSize = 22.sp),
    bodySmall = TextStyle(fontFamily = FontFamily.Default, fontSize = 20.sp),
    labelLarge = TextStyle(fontFamily = FontFamily.Default, fontSize = 26.sp),
    labelMedium = TextStyle(fontFamily = FontFamily.Default, fontSize = 22.sp),
    labelSmall = TextStyle(fontFamily = FontFamily.Default, fontSize = 20.sp),
)

@Composable
fun FarmToPalmTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme,
        typography = FarmToPalmTypography,
        content = content
    )
}
