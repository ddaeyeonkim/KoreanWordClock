package com.pekka.data.local

import android.content.SharedPreferences

class SettingDataSourceImpl(
    private val preferences: SharedPreferences,
) : SettingDataSource {
    override fun updateUiMode(mode: String) {
        preferences.edit().putString("ui_mode", mode).apply()
    }

    override fun getUiMode(): String? {
        return preferences.getString("ui_mode", null)
    }
}
