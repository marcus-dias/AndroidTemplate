package com.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CountryEntity(
    @PrimaryKey
    val name: String,
    val flagUrl: String
)