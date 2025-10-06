package com.example.kmp_room_database.core.database

import androidx.room.RoomDatabase

object DatabaseProvider {
    private var instance: AppDatabase? = null

    fun provideDatabase(builder: RoomDatabase.Builder<AppDatabase>): AppDatabase {
        if (instance == null) {
            instance = getRoomDatabase(builder)
        }
        return instance!!
    }
}