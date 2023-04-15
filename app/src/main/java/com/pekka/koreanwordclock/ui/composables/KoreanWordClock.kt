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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
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
    size: Int = 300,
    wordPadding: Int = 0,
    fontFamily: FontFamily = nanumMyeongjoFamily,
) {
    val words = createCurrentKoreanWords(hour, minute)

    val wordPerRow = 6
    val padding = 16
    val wordSize = (size - padding * 2) / wordPerRow

    Surface(
        color = Color(0x33000000),
    ) {
        Column(
            modifier = modifier.width(size.dp).aspectRatio(1f).padding(padding.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            words.chunked(wordPerRow).forEach { row ->
                KoreanWordRow(
                    row,
                    wordSize = wordSize,
                    wordPadding = wordPadding,
                    fontFamily = fontFamily,
                )
            }
        }
    }
}

@Composable
fun KoreanWordRow(
    words: List<Word>,
    wordSize: Int,
    wordPadding: Int,
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
                wordSize = wordSize,
                wordPadding = wordPadding,
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
    wordSize: Int = 20,
    wordPadding: Int = 0,
    fontFamily: FontFamily = nanumMyeongjoFamily,
    ) {
    AutoSizeText(
        word,
        modifier = modifier.width(wordSize.dp).aspectRatio(1f).padding(wordPadding.dp),
        color = if (isActive) color else Color.Gray,
        fontSize = (wordSize - (wordPadding * 2)).sp,
        textAlign = TextAlign.Center,
        style = LocalTextStyle.current.merge(
            TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false,
                ),
                lineHeightStyle = LineHeightStyle(
                    alignment = LineHeightStyle.Alignment.Center,
                    trim = LineHeightStyle.Trim.Both,
                ),
                fontFamily = fontFamily,
                fontWeight = FontWeight.ExtraBold,
            )
        ),
    )
}

@Preview
@Composable
fun KoreanWordPreview() {
    KoreanWord("한", wordSize = 20, isActive = true, color = Color.Red)
}

@Preview
@Composable
fun KoreanWordClockPreview() {
    KoreanWordClock(
        hour = 12,
        minute = 29,
        modifier = Modifier,
        wordPadding = 4,
        fontFamily = nanumGothicFamily,
    )
}
