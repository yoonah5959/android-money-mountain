package com.heenu.moneymountain.ui.main

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.heenu.design.ui.theme.HeenuTheme
import com.heenu.moneymountain.ui.main.page.HistoryScreen
import com.heenu.moneymountain.ui.main.page.HomeScreen
import com.heenu.moneymountain.ui.main.page.SettingScreen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    HeenuTheme {
        Scaffold(modifier = Modifier.fillMaxSize(), bottomBar = {
            BottomNavBar(navController)
        }) { padding ->
            NavigationGraph(padding, navController)
        }
    }
}


@Composable
fun BottomNavBar(navController: NavHostController) {
    NavigationBar() {
        val backStackEntry = navController.currentBackStackEntryAsState()

        BottomNavItem.toList().forEach { item ->
            val selected = item.route == backStackEntry.value?.destination?.route
            NavigationBarItem(
                selected = selected,
                onClick = { navController.navigate(item.route) },
                label = {
                    Text(
                        text = item.title,
                        fontWeight = FontWeight.SemiBold,
                    )
                },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = "${item.title} Icon",
                    )
                }
            )
        }
    }
}

@Composable
fun NavigationGraph(padding: PaddingValues, navController: NavHostController) {
    NavHost(navController = navController, startDestination = BottomNavItem.Home.route) {
        composable(BottomNavItem.Home.route) {
            HomeScreen()
        }
        composable(BottomNavItem.History.route) {
            HistoryScreen()
        }
        composable(BottomNavItem.Setting.route) {
            SettingScreen()
        }
    }
}