package com.pekka.koreanwordclock

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.pekka.common.activity.BaseActivity
import com.pekka.data.model.UiMode
import com.pekka.koreanwordclock.ui.navigation.KoreanWordClockNavHost
import com.pekka.koreanwordclock.ui.theme.KoreanWordClockTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val uiMode by viewModel.uiMode.collectAsState()

            val darkTheme = when (uiMode) {
                UiMode.DAY -> false
                UiMode.NIGHT -> true
                UiMode.SYSTEM -> isSystemInDarkTheme()
            }

            KoreanWordClockTheme(
                darkTheme = darkTheme,
            ) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    KoreanWordClockNavHost()
                }
            }
        }
    }
}
