package com.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.database.dao.CountryDao
import com.database.entities.CountryEntity

@Database(entities = [CountryEntity::class], version = 1)
@TypeConverters()
abstract class AppDatabase : RoomDatabase() {
    abstract fun countryDao(): CountryDao
}
