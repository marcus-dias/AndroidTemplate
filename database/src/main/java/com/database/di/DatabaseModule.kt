package com.database.di

import android.content.Context
import androidx.room.Room
import com.database.AppDatabase
import com.database.dao.CountryDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase =
        Room.databaseBuilder(appContext, AppDatabase::class.java, "my_app_database.db")
            .build()

    @Provides
    @Singleton
    fun providesCountryDao(appDatabase: AppDatabase): CountryDao = appDatabase.countryDao()
}
