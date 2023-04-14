package com.pekka.koreanwordclock.ui.model

import androidx.compose.ui.graphics.Color

val koreanWords = listOf(
    "한", "두", "세", "네", "다", "섯",
    "여", "섯", "일", "곱", "여", "덟",
    "아", "홉", "열", "한", "두", "시",
    "오", "이", "삼", "사", "오", "십",
    "전", "일", "이", "삼", "사", "오",
    "후", "육", "칠", "팔", "구", "분",
)

data class Word(
    val word: String,
    val isActive: Boolean = false,
    val color: Color = Color.Gray,
)

fun createCurrentKoreanWords(hour: Int, minute: Int): List<Word> {
    val list = koreanWords.map { Word(it) }.toMutableList()

    when (hour % 12) {
        1 -> list[0] = Word("한", isActive = true, color = Color.White)
        2 -> list[1] = Word("두", isActive = true, color = Color.White)
        3 -> list[2] = Word("세", isActive = true, color = Color.White)
        4 -> list[3] = Word("네", isActive = true, color = Color.White)
        5 -> {
            list[4] = Word("다", isActive = true, color = Color.White)
            list[5] = Word("섯", isActive = true, color = Color.White)
        }
        6 -> {
            list[6] = Word("여", isActive = true, color = Color.White)
            list[7] = Word("섯", isActive = true, color = Color.White)
        }
        7 -> {
            list[8] = Word("일", isActive = true, color = Color.White)
            list[9] = Word("곱", isActive = true, color = Color.White)
        }
        8 -> {
            list[10] = Word("여", isActive = true, color = Color.White)
            list[11] = Word("덟", isActive = true, color = Color.White)
        }
        9 -> {
            list[12] = Word("아", isActive = true, color = Color.White)
            list[13] = Word("홉", isActive = true, color = Color.White)
        }
        10 -> {
            list[13] = Word("열", isActive = true, color = Color.White)
        }
        11 -> {
            list[14] = Word("열", isActive = true, color = Color.White)
            list[15] = Word("한", isActive = true, color = Color.White)
        }
        0 -> {
            list[14] = Word("열", isActive = true, color = Color.White)
            list[16] = Word("두", isActive = true, color = Color.White)
        }
        else -> Unit
    }

    list[17] = Word("시", isActive = true, color = Color.White)

    val isAfterNoon = hour >= 12

    if (isAfterNoon) {
        list[18] = Word("오", isActive = true, color = Color.Red)
        list[30] = Word("후", isActive = true, color = Color.Red)
    } else {
        list[18] = Word("오", isActive = true, color = Color.Blue)
        list[24] = Word("전", isActive = true, color = Color.Blue)
    }

    if (minute != 0) {
        val tens = minute / 10

        if (tens > 0) {
            when (tens) {
                2 -> list[19] = Word("이", isActive = true, color = Color.White)
                3 -> list[20] = Word("삼", isActive = true, color = Color.White)
                4 -> list[21] = Word("사", isActive = true, color = Color.White)
                5 -> list[22] = Word("오", isActive = true, color = Color.White)
                else -> Unit
            }

            list[23] = Word("십", isActive = true, color = Color.White)
        }

        val units = minute % 10

        if (units > 0) {
            when (units) {
                1 -> list[25] = Word("일", isActive = true, color = Color.White)
                2 -> list[26] = Word("이", isActive = true, color = Color.White)
                3 -> list[27] = Word("삼", isActive = true, color = Color.White)
                4 -> list[28] = Word("사", isActive = true, color = Color.White)
                5 -> list[29] = Word("오", isActive = true, color = Color.White)
                6 -> list[31] = Word("육", isActive = true, color = Color.White)
                7 -> list[32] = Word("칠", isActive = true, color = Color.White)
                8 -> list[33] = Word("팔", isActive = true, color = Color.White)
                9 -> list[34] = Word("구", isActive = true, color = Color.White)
                else -> Unit
            }
        }

        list[35] = Word("분", isActive = true, color = Color.White)
    }

    return list
}
