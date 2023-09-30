package com.heenu.moneymountain.ui.main

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.List
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import kotlin.reflect.KClass


sealed class BottomNavItem(var icon: ImageVector, var route: String) {

    companion object {
        fun toList(): List<BottomNavItem> {
            return listOf(
                Home, History, Setting
            )
        }
    }

    object Home : BottomNavItem(Icons.Rounded.Home, "home")
    object History : BottomNavItem(Icons.Rounded.List, "history")
    object Setting : BottomNavItem(Icons.Rounded.Settings, "setting")
}