package com.example.kmp_room_database.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.kmp_room_database.features.home.CreateScreen
import com.example.kmp_room_database.features.home.HomeScreen


@Composable
fun Navigation () {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.Home) {
        composable<Routes.Home>(){ HomeScreen(navController) }
        composable<Routes.Create>(){ backStackEntry ->
            val params = backStackEntry.toRoute<Routes.Create>()
            CreateScreen(navController, params )
        }
    }
}