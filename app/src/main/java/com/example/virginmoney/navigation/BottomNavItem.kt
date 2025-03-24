package com.example.virginmoney.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(val route: String, val icon: ImageVector, val label: String) {
    data object People : BottomNavItem("people", Icons.Default.Person, "People")
    data object Rooms : BottomNavItem("rooms", Icons.Default.Home, "Rooms")
}