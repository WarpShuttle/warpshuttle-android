package com.android.warpshuttle.presentation.feature.dashboard.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.android.warpshuttle.presentation.feature.dashboard.NavigationItem
import com.android.warpshuttle.presentation.ui.theme.AppTheme

@Composable
fun TopBar() {
    TopAppBar(
        title = { Text(text = "AppName", fontSize = 18.sp) },
        backgroundColor = Color.Yellow,
        contentColor = Color.White
    )
}

@Composable
fun DashboardScreen() {
    val navController = rememberNavController()

    Scaffold(
        topBar = { },
        bottomBar = { BottomNavigationBar(navController) },
        content = { padding ->
            Box(modifier = Modifier.padding(padding)) {
                Navigation(navController = navController)
            }
        },
        containerColor = AppTheme.colors.colorWhite
    )
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Team,
        NavigationItem.Blog,
        NavigationItem.Alert
    )

    Surface(
        shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
        modifier = Modifier
            .navigationBarsPadding()
            .fillMaxWidth(),
    ) {
        BottomNavigation(
            backgroundColor = AppTheme.colors.colorWhite,
            contentColor = AppTheme.colors.colorWhite,
        ) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
            items.forEach { item ->
                BottomNavigationItem(
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.label
                        )
                    },
                    label = {
                        androidx.compose.material3.Text(
                            text = item.label,
                            textAlign = TextAlign.Start,
                            style = AppTheme.typography.caption.copy(color = AppTheme.colors.colorGray),
                        )
                    },
                    selectedContentColor = AppTheme.colors.colorBrightBlue,
                    unselectedContentColor = AppTheme.colors.colorButtonGray,
                    alwaysShowLabel = true,
                    selected = currentRoute == item.route,
                    onClick = {
                        navController.navigate(item.route) {
                            navController.graph.startDestinationRoute?.let { route ->
                                popUpTo(route) {
                                    saveState = true
                                }
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }
    }

}

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = NavigationItem.Home.route) {
        composable(NavigationItem.Home.route) {
            HomeScreen()
        }
        composable(NavigationItem.Team.route) {
            TeamScreen()
        }
        composable(NavigationItem.Blog.route) {
            BlogScreen()
        }
        composable(NavigationItem.Alert.route) {
            AlertScreen()
        }
    }
}