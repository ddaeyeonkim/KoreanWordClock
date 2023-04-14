package com.pekka.data.local

interface SettingDataSource {
    fun updateUiMode(mode: String)
    fun getUiMode(): String?
}
