package com.heenu.moneymountain.ui.main

import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.heenu.design.ui.theme.DColor
import com.heenu.design.ui.theme.HeenuTheme
import com.heenu.moneymountain.ui.main.page.HistoryScreen
import com.heenu.moneymountain.ui.main.page.HomeScreen
import com.heenu.moneymountain.ui.main.page.SettingScreen
import com.heenu.moneymountain.ui.navigation.NavigationActions
import timber.log.Timber


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val navigationActions = remember(navController) {
        NavigationActions(navController)
    }
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val selectedDestination: String =
        navBackStackEntry?.destination?.route ?: BottomNavItem.Home.route

    HeenuTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = {
                BottomNavBar(
                    selectedDestination,
                    navigationActions::navigateTo
                )
            },
            floatingActionButton = { WriteFloatingButton() }) { padding ->
            NavigationGraph(padding, navController)
        }
    }
}

@Composable
fun WriteFloatingButton() {
    FloatingActionButton(
        shape = RoundedCornerShape(100.dp),
        contentColor = DColor.White,
        containerColor = DColor.Yellow,
        onClick = { }) {
        Icon(Icons.Rounded.Add, null)
    }
}

@Composable
fun BottomNavBar(
    selectedDestination: String,
    navigateToTopLevelDestination: (BottomNavItem) -> Unit
) {
    NavigationBar {
        BottomNavItem.toList().forEach { item ->
            val selected = item.route == selectedDestination
            Timber.d("tag1 NavigationBar $selectedDestination  ${item.route}")
            NavigationBarItem(
                selected = selected,
                onClick = { navigateToTopLevelDestination(item) },
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
    }
}


@Preview("mainScreen")
@Composable
fun PreviewMain() {
    HeenuTheme {
        MainScreen()
    }
}