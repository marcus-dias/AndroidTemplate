package com.use_cases.country

import com.repositories_interfaces.country.CountryRepository
import javax.inject.Inject

class GetCountriesUseCase @Inject constructor(
    private val countryRepository: CountryRepository
) {
}