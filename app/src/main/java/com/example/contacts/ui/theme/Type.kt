package com.example.contacts.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.contacts.R

val fonts = FontFamily(
    Font(R.font.raleway_thin, weight = FontWeight.Thin),
    Font(R.font.raleway_extralight, weight = FontWeight.ExtraLight),
    Font(R.font.raleway_light, weight = FontWeight.Light),
    Font(R.font.raleway_regular, weight = FontWeight.Normal),
    Font(R.font.raleway_medium, weight = FontWeight.Medium),
    Font(R.font.raleway_semibold, weight = FontWeight.SemiBold),
    Font(R.font.raleway_bold, weight = FontWeight.Bold),
    Font(R.font.raleway_extrabold, weight = FontWeight.ExtraBold),
    Font(R.font.raleway_black, weight = FontWeight.Black)
)

val typography = androidx.compose.material3.Typography(
 titleLarge = TextStyle(fontFamily = fonts, fontWeight = FontWeight.Bold, fontSize = 31.sp),
    labelSmall = TextStyle(fontFamily = fonts, fontWeight = FontWeight.Bold, fontSize = 14.sp),
    bodyMedium = TextStyle(fontFamily = fonts, fontWeight = FontWeight.Normal, fontSize = 18.sp),

    )