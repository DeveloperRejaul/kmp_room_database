package com.example.kmp_room_database

import com.example.kmp_room_database.core.database.AppDatabase
import androidx.compose.ui.window.ComposeUIViewController

// provide data base from here
fun MainViewController(database: AppDatabase) = ComposeUIViewController { App(database) }