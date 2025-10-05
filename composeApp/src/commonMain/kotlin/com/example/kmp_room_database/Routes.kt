package com.example.kmp_room_database
import kotlinx.serialization.Serializable


sealed interface Routes {
    @Serializable
    data object Home : Routes

    @Serializable
    data object Create : Routes
}