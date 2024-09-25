package com.android.warpshuttle.presentation.feature.dashboard

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationItem(
    val route: String,
    val label: String,
    val icon: ImageVector
) {
    data object Home : NavigationItem(
        route = "home",
        label = "Home",
        icon = Icons.Rounded.Home
    )

    data object Team : NavigationItem(
        route = "tasks",
        label = "Team",
        icon = Icons.Rounded.AccountBox
    )

    data object Blog : NavigationItem(
        route = "options",
        label = "Blog",
        icon = Icons.Rounded.DateRange
    )

    data object Alert : NavigationItem(
        route = "options",
        label = "Alert",
        icon = Icons.Rounded.Notifications
    )
}