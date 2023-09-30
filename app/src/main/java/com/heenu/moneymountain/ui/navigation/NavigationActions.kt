package com.heenu.moneymountain.ui.navigation

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.heenu.moneymountain.ui.main.BottomNavItem

class NavigationActions(private val navController: NavHostController) {
    fun navigateTo(destination: BottomNavItem) {
        navController.navigate(destination.route) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            // Restore state when reselecting a previously selected item
            restoreState = true
        }
    }
}