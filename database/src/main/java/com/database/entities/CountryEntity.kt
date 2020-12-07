package com.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.domain_model.country.Country

@Entity
data class CountryEntity(
    @PrimaryKey
    val name: String,
    val flagUrl: String
)

fun List<CountryEntity>.toDomain() = map { it.toDomain() }
fun List<Country>.toEntity() = map { it.toEntity() }
fun CountryEntity.toDomain() = Country(this.name, this.flagUrl)
fun Country.toEntity() = CountryEntity(this.name, this.flagUrl)