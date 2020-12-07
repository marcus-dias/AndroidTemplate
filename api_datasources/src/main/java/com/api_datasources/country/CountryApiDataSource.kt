package com.api_datasources.country

import com.domain_model.country.Country

interface CountryApiDataSource {
    suspend fun getCountries(): List<Country>
}