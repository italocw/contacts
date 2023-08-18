package com.example.contacts.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController


private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40,
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = AvantsoftLogoBackground,
    onSurface = AvantsoftLogoBackground
)

@Composable
fun ContactsTheme(
    content: @Composable () -> Unit
) {
    val colorScheme =LightColorScheme
    val systemUiController = rememberSystemUiController()

    systemUiController.setSystemBarsColor(
        color = colorScheme.onBackground
    )

    MaterialTheme(
        colorScheme = colorScheme,
        typography = typography,
        content = content
    )
}