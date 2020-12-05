package com.repositories_interfaces.country

import com.domain_model.Country
import com.repositories_interfaces.Repository

interface CountryRepository : Repository {
    suspend fun getCountries(): List<Country>
}