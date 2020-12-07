package com.repositories.implementations.country

import com.api_datasources.country.CountryApiDataSource
import com.database_datasources.country.CountryDatabaseDataSource
import com.domain_model.DomainResult
import com.domain_model.country.Country
import com.repositories.BaseRepository
import com.repositories_interfaces.country.CountryRepository
import javax.inject.Inject

class CountryRepositoryImpl @Inject constructor(
    private val countryApiDataSource: CountryApiDataSource,
    private val countryDatabaseDataSource: CountryDatabaseDataSource
) : BaseRepository(), CountryRepository {
    override suspend fun getCountries(): DomainResult<List<Country>> {
        return safeCallToResult {
            val dbCountries = countryDatabaseDataSource.getCountries()
            return@safeCallToResult if (dbCountries.isNotEmpty()) {
                dbCountries
            } else {
                val apiCountries = countryApiDataSource.getCountries()
                countryDatabaseDataSource.insertCountries(apiCountries)
                apiCountries
            }
        }
    }
}