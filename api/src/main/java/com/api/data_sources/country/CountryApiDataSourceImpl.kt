package com.api.data_sources.country

import com.api.ApiServices
import com.api.data_sources.BaseApiDataSource
import com.api.model.toDomain
import com.api_datasources.country.CountryApiDataSource
import com.domain_model.country.Country
import javax.inject.Inject

class CountryApiDataSourceImpl @Inject constructor(
    private val apiServices: ApiServices
) : BaseApiDataSource(), CountryApiDataSource {
    override suspend fun getCountries(): List<Country> {
        return apiServices.getCountries().toDomain()
    }
}