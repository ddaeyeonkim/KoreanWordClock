package com.pekka.koreanwordclock.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pekka.koreanwordclock.R
import com.pekka.koreanwordclock.ui.composables.KoreanWordClock
import com.pekka.koreanwordclock.ui.composables.lifecycle.DisposableEffectWithLifecycle
import kotlin.math.min

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    onSettingClick: () -> Unit = {},
) {
    val hour by viewModel.hour.collectAsState()
    val minute by viewModel.minute.collectAsState()

    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp
    val screenHeight = configuration.screenHeightDp

    val size = min(screenWidth, screenHeight) * 0.8f

    DisposableEffectWithLifecycle(
        onStart = viewModel::start,
        onStop = viewModel::stop,
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(stringResource(id = R.string.app_name))
                },
                actions = {
                    IconButton(onClick = onSettingClick) {
                        Icon(Icons.Filled.Settings, contentDescription = "설정")
                    }
                },
            )
        }
    ) { innerPadding ->
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
