package com.nirvikbasnet.pdfreader.ui.navigation.bottomNavigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

enum class BottomNavItems(val route: String, val title: String, val icon: ImageVector) {
    List("list", "List", Icons.Default.List),
    Download("download", "Download", Icons.Default.ArrowDropDown),

}
