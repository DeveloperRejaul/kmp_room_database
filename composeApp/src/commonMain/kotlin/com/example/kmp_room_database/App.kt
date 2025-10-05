package com.example.kmp_room_database

import AppDatabase
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*

@Composable
fun App(database: AppDatabase) {
    MaterialTheme {
        Navigation()
    }
}
