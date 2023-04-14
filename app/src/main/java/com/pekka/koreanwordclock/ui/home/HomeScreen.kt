package com.pekka.koreanwordclock.ui.home

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pekka.koreanwordclock.ui.composables.KoreanWordClock
import com.pekka.koreanwordclock.ui.composables.lifecycle.DisposableEffectWithLifecycle
import kotlin.math.min

@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    val hour by viewModel.hour.collectAsState()
    val minute by viewModel.minute.collectAsState()

    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp
    val screenHeight = configuration.screenHeightDp

    val size = min(screenWidth, screenHeight) * 0.8f

    DisposableEffectWithLifecycle(
        onStart = {
            Log.e("test", "onStart")
            viewModel.start()
        },
        onStop = {
            Log.e("test", "onStop")
            viewModel.stop()
        },
    )

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            KoreanWordClock(
                hour = hour,
                minute = minute,
                modifier = Modifier.width(size.dp),
                fontSize = 36.sp,
            )
        }
    }
}
