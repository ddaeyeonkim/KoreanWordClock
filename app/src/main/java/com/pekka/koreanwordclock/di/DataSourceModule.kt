package com.pekka.koreanwordclock.di

import com.pekka.data.local.SettingDataSource
import com.pekka.data.local.SettingDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Singleton
    @Binds
    abstract fun bindSettingDataSource(settingDataSource: SettingDataSourceImpl): SettingDataSource
}
