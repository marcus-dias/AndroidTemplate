package com.repositories.di

import com.repositories.implementations.country.CountryRepositoryImpl
import com.repositories_interfaces.country.CountryRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
abstract class RepositoryModule {
    @Singleton
    @Binds
    abstract fun bindCountryRepository(repositoryImpl: CountryRepositoryImpl): CountryRepository
}