package com.database.di

import com.database.data_sources.country.CountryDatabaseDataSourceImpl
import com.database_datasources.country.CountryDatabaseDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
abstract class DatabaseDataSourceModule {
    @Singleton
    @Binds
    abstract fun bindCountryDataSource(Impl: CountryDatabaseDataSourceImpl): CountryDatabaseDataSource
}
