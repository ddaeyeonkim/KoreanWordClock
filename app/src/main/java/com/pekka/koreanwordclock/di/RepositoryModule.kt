package com.pekka.koreanwordclock.di

import com.pekka.data.repository.SettingRepository
import com.pekka.data.repository.SettingRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindSettingRepository(settingRepository: SettingRepositoryImpl): SettingRepository
}