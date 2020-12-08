package com.ui_model.country

import com.domain_model.country.Country

data class UiCountry(val name: String, val flagUrl: String)

fun List<UiCountry>.toDomain() = map { it.toDomain() }
fun List<Country>.toUi() = map { it.toUi() }
fun UiCountry.toDomain() = Country(this.name, this.flagUrl)
fun Country.toUi() = UiCountry(this.name, this.flagUrl)