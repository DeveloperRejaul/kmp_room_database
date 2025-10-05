package com.example.kmp_room_database

import AppDatabase
import androidx.compose.ui.window.ComposeUIViewController

// provide data base from here
fun MainViewController(database: AppDatabase) = ComposeUIViewController { App(database) }