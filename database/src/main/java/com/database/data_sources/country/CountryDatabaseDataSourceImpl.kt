package com.database.data_sources.country

import com.database.dao.CountryDao
import com.database.data_sources.BaseDatabaseDataSource
import com.database.entities.toDomain
import com.database.entities.toEntity
import com.database_datasources.country.CountryDatabaseDataSource
import com.domain_model.country.Country
import javax.inject.Inject

class CountryDatabaseDataSourceImpl @Inject constructor(
    private val countryDao: CountryDao
) : BaseDatabaseDataSource(), CountryDatabaseDataSource {
    override suspend fun getCountries(): List<Country> {
        return countryDao.getCountries().toDomain()
    }

    override suspend fun insertCountries(countries: List<Country>) {
        countryDao.insertCountries(countries.toEntity())
    }
}