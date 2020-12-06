package com.repositories.implementations.country

import com.domain_model.Country
import com.repositories.BaseRepository
import com.repositories_interfaces.country.CountryRepository
import javax.inject.Inject

class CountryRepositoryImpl @Inject constructor() : BaseRepository(), CountryRepository {
    override suspend fun getCountries(): List<Country> {
        return emptyList()
    }
}