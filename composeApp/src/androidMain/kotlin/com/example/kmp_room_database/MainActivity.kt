package com.example.kmp_room_database

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import getDatabaseBuilder

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        // provide database
        val db = DatabaseProvider.provideDatabase(getDatabaseBuilder(applicationContext))
        setContent {
            App(database = db)
        }
    }
}