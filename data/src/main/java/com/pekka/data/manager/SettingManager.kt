package com.pekka.data.manager

import com.pekka.data.model.Setting
import com.pekka.data.model.UiMode
import com.pekka.data.repository.SettingRepository
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

@Singleton
class SettingManager @Inject constructor(
    private val settingRepository: SettingRepository,
) {

    private val _setting = MutableStateFlow(Setting())
    val settingFlow get() = _setting.asStateFlow()

    init {
        val uiMode = settingRepository.getUiMode()
        _setting.value = _setting.value.copy(uiMode = uiMode)
    }

    fun updateUiMode(mode: UiMode) {
        settingRepository.updateUiMode(mode)
        _setting.value = _setting.value.copy(uiMode = mode)
    }
}
