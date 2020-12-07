package com.api.model

import com.domain_model.country.Country
import com.google.gson.annotations.SerializedName

data class RemoteCountry(
    @SerializedName("name")
    val name: String?,
    @SerializedName("flag")
    val flag: String?,
)

fun List<RemoteCountry>.toDomain() = map { it.toDomain() }
fun List<Country>.toApi() = map { it.toApi() }
fun RemoteCountry.toDomain() = Country(this.name ?: "", this.flag ?: "")
fun Country.toApi() = RemoteCountry(this.name, this.flagUrl)