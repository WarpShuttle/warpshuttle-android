package com.android.warpshuttle.navigation

sealed class Screen(val route: String) {
    data object Splash : Screen("splash_screen")
    data object Intro: Screen("intro_screen")
    data object Login :Screen("login_screen")

    data object Dashboard :Screen("dashboard_screen")

}