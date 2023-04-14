package com.pekka.koreanwordclock

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pekka.data.manager.SettingManager
import com.pekka.data.model.UiMode
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class MainViewModel @Inject constructor(
    private val settingManager: SettingManager,
) : ViewModel() {

    private val _uiMode = MutableStateFlow(UiMode.SYSTEM)
    val uiMode get() = _uiMode.asStateFlow()

    init {
        viewModelScope.launch {
            settingManager.settingFlow.collect { setting ->
                _uiMode.value = setting.uiMode
            }
        }
    }
}
