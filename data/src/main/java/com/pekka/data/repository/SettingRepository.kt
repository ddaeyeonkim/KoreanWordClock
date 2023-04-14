package com.pekka.data.repository

import com.pekka.data.model.UiMode

interface SettingRepository {
    fun getUiMode(): UiMode
}
