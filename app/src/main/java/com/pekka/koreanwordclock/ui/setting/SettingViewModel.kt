package com.pekka.koreanwordclock.ui.setting

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pekka.data.manager.SettingManager
import com.pekka.data.model.Setting
import com.pekka.data.model.UiMode
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class SettingViewModel @Inject constructor(
    private val settingManager: SettingManager,
) : ViewModel() {

    private val _setting = MutableStateFlow(Setting())
    val setting get() = _setting.asStateFlow()

    private val _openUiModeDialog = MutableStateFlow(false)
    val openUiModeDialog get() = _openUiModeDialog.asStateFlow()

    init {
        viewModelScope.launch {
            settingManager.settingFlow
                .collect {
                    _setting.value = it
                }
        }
    }

    fun updateUiMode(mode: UiMode) {
        settingManager.updateUiMode(mode)
    }

    fun openUiModeDialog() {
        _openUiModeDialog.value = true
    }

    fun hideUiModeDialog() {
        _openUiModeDialog.value = false
    }
}
