package com.database_datasources.country

import com.domain_model.country.Country

interface CountryDatabaseDataSource {
    suspend fun insertCountries(countries: List<Country>)
    suspend fun getCountries(): List<Country>
}