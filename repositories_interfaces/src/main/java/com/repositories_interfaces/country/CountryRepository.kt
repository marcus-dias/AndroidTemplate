package com.repositories_interfaces.country

import com.domain_model.DomainResult
import com.domain_model.country.Country
import com.repositories_interfaces.Repository

interface CountryRepository : Repository {
    suspend fun getCountries(): DomainResult<List<Country>>
}