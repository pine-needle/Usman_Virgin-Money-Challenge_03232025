package com.example.virginmoney.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.feature_people.ColleaguesListScreen
import com.example.feature_rooms.AvailableRoomsScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = BottomNavItem.People.route) {
        composable(BottomNavItem.People.route) {
            ColleaguesListScreen()
        }
        composable(BottomNavItem.Rooms.route) {
            AvailableRoomsScreen()
        }
    }
}