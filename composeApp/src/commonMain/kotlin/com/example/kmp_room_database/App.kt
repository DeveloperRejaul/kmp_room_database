package com.example.kmp_room_database

import com.example.kmp_room_database.core.database.AppDatabase
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.runtime.staticCompositionLocalOf
import com.example.kmp_room_database.core.navigation.Navigation


val LocalDatabase = staticCompositionLocalOf<AppDatabase> {
    error("No Database provided")
}

@Composable
fun App(database: AppDatabase) {
    MaterialTheme {
        CompositionLocalProvider( LocalDatabase provides database) {
            Navigation()
        }
    }
}
