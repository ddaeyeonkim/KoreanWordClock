package com.pekka.koreanwordclock.ui.setting

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.pekka.data.model.UiMode

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingScreen(viewModel: SettingViewModel) {
    val setting by viewModel.setting.collectAsState()
    val openUiModeDialog by viewModel.openUiModeDialog.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("설정")
                },
            )
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        viewModel.openUiModeDialog()
                    }
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text("테마")
                Text(getUiModeDisplayName(setting.uiMode))
            }
        }

        if (openUiModeDialog) {
            Dialog(onDismissRequest = { viewModel.hideUiModeDialog() }) {
                UiModeDialogContent(
                    uiMode = setting.uiMode,
                    onItemClick = { mode ->
                        viewModel.updateUiMode(mode)
                    },
                    onDismiss = {
                        viewModel.hideUiModeDialog()
                    }
                )
            }
        }
    }
}

@Composable
fun UiModeDialogContent(
    uiMode: UiMode,
    onItemClick: (uiMode: UiMode) -> Unit,
    onDismiss: () -> Unit,
) {
    var selectedUiMode by remember { mutableStateOf(uiMode) }

    Surface(
        shape = RoundedCornerShape(12.dp),
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            UiMode.values().forEach { uiMode ->
                UiModeRow(
                    selected = selectedUiMode == uiMode,
                    text = getUiModeDisplayName(uiMode),
                    onClick = {
                        selectedUiMode = uiMode
                        onItemClick(uiMode)
                    }
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
            ) {
                ElevatedButton(
                    modifier = Modifier.width(200.dp),
                    onClick = onDismiss,
                ) {
                    Text("확인")
                }
            }
        }
    }
}

@Composable
fun UiModeRow(
    selected: Boolean,
    text: String,
    onClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(8.dp),
        horizontalArrangement = Arrangement.Start,
    ) {
        RadioButton(selected = selected, onClick = null)
        Spacer(modifier = Modifier.width(8.dp))
        Text(text)
    }
}

private fun getUiModeDisplayName(uiMode: UiMode): String {
    return when (uiMode) {
        UiMode.SYSTEM -> "System mode"
        UiMode.DAY -> "Light mode"
        UiMode.NIGHT -> "Dark mode"
    }
}