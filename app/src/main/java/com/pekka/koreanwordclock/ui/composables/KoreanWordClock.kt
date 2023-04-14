package com.pekka.koreanwordclock.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pekka.koreanwordclock.ui.model.Word
import com.pekka.koreanwordclock.ui.model.createCurrentKoreanWords
import com.pekka.koreanwordclock.ui.theme.nanumGothicFamily
import com.pekka.koreanwordclock.ui.theme.nanumMyeongjoFamily

@Composable
fun KoreanWordClock(
    hour: Int,
    minute: Int,
    modifier: Modifier = Modifier,
    fontSize: TextUnit = 24.sp,
    fontFamily: FontFamily = nanumMyeongjoFamily,
) {
    val words = createCurrentKoreanWords(hour, minute)

    Surface(
        color = Color(0x33000000),
    ) {
        Column(
            modifier = modifier.aspectRatio(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            words.chunked(6).forEach { row ->
                KoreanWordRow(row, fontSize, fontFamily)
            }
        }
    }
}

@Composable
fun KoreanWordRow(
    words: List<Word>,
    fontSize: TextUnit = 24.sp,
    fontFamily: FontFamily = nanumMyeongjoFamily,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
    ) {
        words.forEach { word ->
            KoreanWord(
                word = word.word,
                isActive = word.isActive,
                color = word.color,
                fontSize = fontSize,
                fontFamily = fontFamily,
            )
        }
    }
}

@Composable
fun KoreanWord(
    word: String,
    modifier: Modifier = Modifier,
    isActive: Boolean,
    color: Color,
    fontSize: TextUnit = 24.sp,
    fontFamily: FontFamily = nanumMyeongjoFamily,
    ) {
    Text(
        word,
        modifier = modifier.padding(4.dp),
        color = if (isActive) color else Color.Gray,
        fontFamily = fontFamily,
        fontSize = fontSize,
        fontWeight = FontWeight.ExtraBold,
        style = LocalTextStyle.current.merge(
            TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false,
                ),
                lineHeightStyle = LineHeightStyle(
                    alignment = LineHeightStyle.Alignment.Center,
                    trim = LineHeightStyle.Trim.Both,
                )
            )
        )
    )
}

@Preview
@Composable
fun KoreanWordPreview() {
    KoreanWord("한", isActive = true, color = Color.Red)
}

@Preview
@Composable
fun KoreanWordClockPreview() {
    KoreanWordClock(
        hour = 12,
        minute = 29,
        modifier = Modifier.width(300.dp),
        fontFamily = nanumGothicFamily,
    )
}
