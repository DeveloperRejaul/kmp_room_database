package com.example.kmp_room_database

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun Navigation () {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.Home) {
        composable<Routes.Home>(){ HomeScreen(navController) }
        composable<Routes.Create>(){ CreateScreen(navController) }
    }
}