package com.android.warpshuttle.presentation.feature.dashboard.screen

import androidx.activity.enableEdgeToEdge
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
import androidx.core.view.WindowCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.android.warpshuttle.navigation.Screen
import com.android.warpshuttle.navigation.customAnimatedComposable
import com.android.warpshuttle.presentation.ui.theme.AppTheme

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
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            HomeScreen {
                navController.navigate(Screen.Profile.route)
            }
        }
        composable(Screen.Team.route) {
            TeamScreen()
        }

        composable(Screen.Search.route) {
            SearchScreen()
        }

        composable(Screen.Blog.route) {
            BlogScreen()
        }

        composable(Screen.Alert.route) {
            AlertScreen()
        }

        customAnimatedComposable (route = Screen.Profile.route){
            ProfileScreen()
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = listOf(
        Screen.Home,
        Screen.Team,
        Screen.Search,
        Screen.Blog,
        Screen.Alert
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

