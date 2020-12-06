package com.ui_model.mappers.country

import com.ui_model.model.country.UiCountry
import com.domain_model.country.Country

fun List<UiCountry>.toDomain() = map { it.toDomain() }
fun List<Country>.toUi() = map { it.toUi() }
fun UiCountry.toDomain() =
    Country(this.name, this.flagUrl)
fun Country.toUi() = UiCountry(this.name, this.flagUrl)