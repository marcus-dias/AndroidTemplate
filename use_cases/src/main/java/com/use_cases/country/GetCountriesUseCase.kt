package com.use_cases.country

import com.domain_model.DomainResult
import com.domain_model.country.Country
import com.repositories_interfaces.country.CountryRepository
import com.use_cases.UseCase
import com.use_cases.extensions.executeIoOperation
import javax.inject.Inject

class GetCountriesUseCase @Inject constructor(
    private val countryRepository: CountryRepository
) : UseCase() {
    suspend operator fun invoke(): DomainResult<List<Country>> =
        executeIoOperation(countryRepository::getCountries)
}