package com.pekka.data.repository

import com.pekka.data.local.SettingDataSource
import com.pekka.data.model.UiMode

class SettingRepositoryImpl(
    private val settingDataSource: SettingDataSource,
) : SettingRepository {
    override fun getUiMode(): UiMode {
        return settingDataSource.getUiMode()?.let { UiMode.valueOf(it) } ?: UiMode.SYSTEM
    }

    override fun updateUiMode(mode: UiMode) {
        settingDataSource.updateUiMode(mode.name)
    }
}
