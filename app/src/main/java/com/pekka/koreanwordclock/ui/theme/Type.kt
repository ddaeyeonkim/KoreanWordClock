package com.pekka.koreanwordclock.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.pekka.koreanwordclock.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

val nanumGothicFamily = FontFamily(
    Font(R.font.nanum_gothic_light, FontWeight.Light),
    Font(R.font.nanum_gothic_normal, FontWeight.Normal),
    Font(R.font.nanum_gothic_normal, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.nanum_gothic_normal, FontWeight.Medium),
    Font(R.font.nanum_gothic_bold, FontWeight.Bold),
    Font(R.font.nanum_gothic_extra_bold, FontWeight.ExtraBold),
)

val nanumMyeongjoFamily = FontFamily(
    Font(R.font.nanum_myeongjo, FontWeight.Light),
    Font(R.font.nanum_myeongjo, FontWeight.Normal),
    Font(R.font.nanum_myeongjo, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.nanum_myeongjo, FontWeight.Medium),
    Font(R.font.nanum_myeongjo_bold, FontWeight.Bold),
    Font(R.font.nanum_myeongjo_extra_bold, FontWeight.ExtraBold),
)

val nanumSquareRoundFamily = FontFamily(
    Font(R.font.nanum_square_round_light, FontWeight.Light),
    Font(R.font.nanum_square_round_normal, FontWeight.Normal),
    Font(R.font.nanum_square_round_normal, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.nanum_square_round_normal, FontWeight.Medium),
    Font(R.font.nanum_square_round_bold, FontWeight.Bold),
    Font(R.font.nanum_square_round_extra_bold, FontWeight.ExtraBold),
)
