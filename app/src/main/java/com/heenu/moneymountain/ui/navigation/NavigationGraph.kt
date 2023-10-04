package com.heenu.moneymountain.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.heenu.moneymountain.ui.expenditurewriting.ExpenditureWritingScreen
import com.heenu.moneymountain.ui.main.page.HistoryScreen
import com.heenu.moneymountain.ui.main.page.HomeScreen
import com.heenu.moneymountain.ui.main.page.SettingScreen
import timber.log.Timber

@Composable
fun NavigationGraph(padding: PaddingValues, navController: NavHostController) {
    Timber.d("tag1 NavigationGraph")
    NavHost(navController = navController, startDestination = BottomNavItem.Home.route) {
        composable(BottomNavItem.Home.route) {
            Timber.d("tag1 NavigationGraph Home")
            HomeScreen()
        }
        composable(BottomNavItem.History.route) {
            Timber.d("tag1 NavigationGraph History")
            HistoryScreen()
        }
        composable(BottomNavItem.Setting.route) {
            Timber.d("tag1 NavigationGraph Setting")
            SettingScreen()
        }

        composable(Destination.ExpenditureWriting.route) {
            ExpenditureWritingScreen()
        }
    }
}
