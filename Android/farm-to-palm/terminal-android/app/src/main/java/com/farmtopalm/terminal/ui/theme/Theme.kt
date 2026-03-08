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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// ——— Supa School design system (aligned with supaschool tailwind/index.css) ———
// Primary purple #660099, secondary yellow #FFCC00, pastel accents
private val SupaPrimary = Color(0xFF660099)
private val SupaPrimaryLight = Color(0xFFA31AE6)
private val SupaPrimaryDark = Color(0xFF4D0073)
private val SupaSecondary = Color(0xFFFFCC00)
private val SupaSecondaryLight = Color(0xFFFFD633)
private val SupaSecondaryDark = Color(0xFFE6B800)
private val BackgroundLight = Color(0xFFFFFFFF)
private val CardBackgroundLight = Color(0xFFFFFFFF)
private val BorderLight = Color(0xFFE2E8F0)
private val PrimaryTextLight = Color(0xFF0F172A)
private val SecondaryTextLight = Color(0xFF64748B)
private val MutedLight = Color(0xFFF1F5F9)
private val SuccessLight = Color(0xFF16A34A)
private val ErrorLight = Color(0xFFDC2626)

private val LightColorScheme = lightColorScheme(
    primary = SupaPrimary,
    onPrimary = Color.White,
    primaryContainer = SupaPrimary.copy(alpha = 0.12f),
    secondary = SupaSecondary,
    onSecondary = PrimaryTextLight,
    secondaryContainer = SupaSecondaryLight.copy(alpha = 0.4f),
    onSecondaryContainer = PrimaryTextLight,
    surface = CardBackgroundLight,
    surfaceVariant = MutedLight,
    onSurface = PrimaryTextLight,
    onSurfaceVariant = SecondaryTextLight,
    outline = BorderLight,
    error = ErrorLight,
    onError = Color.White,
    tertiary = SuccessLight,
    outlineVariant = BorderLight.copy(alpha = 0.5f),
    background = BackgroundLight,
    onBackground = PrimaryTextLight,
)

// ——— Dark mode (Supa School dark) ———
private val BackgroundDark = Color(0xFF0F172A)
private val CardDark = Color(0xFF1E293B)
private val TextDark = Color(0xFFF8FAFC)

private val DarkColorScheme = darkColorScheme(
    primary = SupaPrimaryLight,
    onPrimary = Color.White,
    secondary = SupaSecondary,
    onSecondary = Color.Black,
    surface = CardDark,
    onSurface = TextDark,
    surfaceVariant = CardDark.copy(alpha = 0.8f),
    onSurfaceVariant = TextDark.copy(alpha = 0.8f),
    outline = TextDark.copy(alpha = 0.3f),
    error = ErrorLight,
    background = BackgroundDark,
    onBackground = TextDark,
)

// ——— Typography: extra large kiosk (greeting 56sp, section 34sp, stat 72sp, button 34sp, small 22sp) ———
private val InterFallback = FontFamily.Default

private val FarmToPalmTypography = Typography(
    headlineMedium = TextStyle(
        fontFamily = InterFallback,
        fontSize = 56.sp,
        fontWeight = FontWeight.SemiBold,
    ),
    titleMedium = TextStyle(
        fontFamily = InterFallback,
        fontSize = 34.sp,
        fontWeight = FontWeight.Medium,
    ),
    titleLarge = TextStyle(
        fontFamily = InterFallback,
        fontSize = 36.sp,
        fontWeight = FontWeight.Medium,
    ),
    headlineLarge = TextStyle(
        fontFamily = InterFallback,
        fontSize = 72.sp,
        fontWeight = FontWeight.Bold,
    ),
    headlineSmall = TextStyle(
        fontFamily = InterFallback,
        fontSize = 64.sp,
        fontWeight = FontWeight.Bold,
    ),
    labelLarge = TextStyle(
        fontFamily = InterFallback,
        fontSize = 34.sp,
        fontWeight = FontWeight.Medium,
    ),
    labelMedium = TextStyle(
        fontFamily = InterFallback,
        fontSize = 28.sp,
        fontWeight = FontWeight.Medium,
    ),
    bodySmall = TextStyle(
        fontFamily = InterFallback,
        fontSize = 22.sp,
        fontWeight = FontWeight.Normal,
    ),
    bodyMedium = TextStyle(
        fontFamily = InterFallback,
        fontSize = 28.sp,
        fontWeight = FontWeight.Normal,
    ),
    bodyLarge = TextStyle(
        fontFamily = InterFallback,
        fontSize = 30.sp,
        fontWeight = FontWeight.Normal,
    ),
    labelSmall = TextStyle(
        fontFamily = InterFallback,
        fontSize = 22.sp,
        fontWeight = FontWeight.Medium,
    ),
    displayLarge = TextStyle(fontFamily = InterFallback, fontSize = 80.sp, fontWeight = FontWeight.Bold),
    displayMedium = TextStyle(fontFamily = InterFallback, fontSize = 72.sp, fontWeight = FontWeight.Bold),
    displaySmall = TextStyle(fontFamily = InterFallback, fontSize = 64.sp, fontWeight = FontWeight.Bold),
)

@Composable
fun FarmToPalmTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme,
        typography = FarmToPalmTypography,
        content = content,
    )
}
