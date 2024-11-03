package lat.pam.a30daysoffitness.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

// Definisi warna
val Purplef = Color(0xFF6200EE)
val PurpleGreyf = Color(0xFF3700B3)
val Pinkf = Color(0xFFFF4081)

val Purplee = Color(0xFFBB86FC)
val PurpleGreyy = Color(0xFF03DAC5)
val Pinkk = Color(0xFFFF80AB)

private val DarkColorScheme = darkColorScheme(
    primary = Purplef,
    secondary = PurpleGreyf,
    tertiary = Pinkf
)

private val LightColorScheme = lightColorScheme(
    primary = Purplee,
    secondary = PurpleGreyy,
    tertiary = Pinkk
)

@Composable
fun _30DaysOfFitnessTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
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
        typography = CustomTypography, // Ganti Typography di sini
        content = content
    )
}
