package com.anorlddroid.masenohostels.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.anorlddroid.masenohostels.R

private val OxygenMono = FontFamily(
    Font(R.font.oxygen_mono_regular, FontWeight.Normal),
)

private val Oxygen = FontFamily(
    Font(R.font.oxygen_regular, FontWeight.Normal),
    Font(R.font.oxygen_light, FontWeight.Light),
    Font(R.font.oxygen_bold, FontWeight.Bold),
)
val Typography = Typography(
    h3 = TextStyle(
        fontFamily = Oxygen,
        fontSize = 48.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 59.sp
    ),
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ) ,
    h5 = TextStyle(
        fontFamily = Oxygen,
        fontSize = 26.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 24.sp
    ),
    h6 = TextStyle(
        fontFamily = OxygenMono,
        fontSize = 20.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 24.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = Oxygen,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 24.sp,
        letterSpacing = 0.15.sp
    ),
    subtitle2 = TextStyle(
        fontFamily = OxygenMono,
        fontSize = 14.sp,
        fontWeight = FontWeight.Light,
        lineHeight = 24.sp,
        letterSpacing = 0.1.sp
    ),
    button = TextStyle(
        fontFamily = OxygenMono,
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 16.sp,
        letterSpacing = 1.25.sp
    ),
)