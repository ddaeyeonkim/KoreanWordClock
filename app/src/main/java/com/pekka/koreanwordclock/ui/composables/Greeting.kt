package com.pekka.koreanwordclock.ui.composables

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.pekka.koreanwordclock.ui.theme.KoreanWordClockTheme

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    KoreanWordClockTheme {
        Greeting("Android")
    }
}