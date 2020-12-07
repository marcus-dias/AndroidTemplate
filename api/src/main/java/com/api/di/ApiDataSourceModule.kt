package com.api.di

import com.api.data_sources.country.CountryApiDataSourceImpl
import com.api_datasources.country.CountryApiDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
abstract class ApiDataSourceModule {
    @Singleton
    @Binds
    abstract fun bindCountryDataSource(Impl: CountryApiDataSourceImpl): CountryApiDataSource
}
