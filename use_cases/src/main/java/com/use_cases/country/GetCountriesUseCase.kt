package com.use_cases.country

import com.domain_model.Country
import com.repositories_interfaces.country.CountryRepository
import com.use_cases.DomainResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetCountriesUseCase @Inject constructor(
    private val countryRepository: CountryRepository
) {
    suspend operator fun invoke(): DomainResult<List<Country>> =
        withContext(Dispatchers.IO) {
            DomainResult.Success(countryRepository.getCountries())
        }
}