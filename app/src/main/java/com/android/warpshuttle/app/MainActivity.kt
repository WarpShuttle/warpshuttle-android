package com.android.warpshuttle.app

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.android.warpshuttle.navigation.Screen
import com.android.warpshuttle.navigation.customAnimatedComposable
import com.android.warpshuttle.navigation.rememberCustomAnimatedNavController
import com.android.warpshuttle.presentation.feature.authentication.screen.LoginScreen
import com.android.warpshuttle.presentation.feature.intro.screen.IntroScreen
import com.android.warpshuttle.presentation.feature.splashscreen.SplashScreen
import com.android.warpshuttle.presentation.ui.theme.AnimatedSplashScreenTheme

class MainActivity : ComponentActivity() {
    private var navController: NavHostController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AnimatedSplashScreenTheme {
                navController = rememberCustomAnimatedNavController()
                SetupNavGraph(navController = navController!!)
            }
        }
    }

    @Composable
    fun SetupNavGraph(navController: NavHostController) {
        NavHost(
            navController = navController,
            startDestination = Screen.Splash.route
        ) {
            customAnimatedComposable(route = Screen.Splash.route) {
                SplashScreen {
                    navController.navigator(
                        Screen.Intro.route,
                        clearBackStack = true
                    )
                }
            }
            customAnimatedComposable(route = Screen.Intro.route){
                IntroScreen ()
            }
            customAnimatedComposable(route = Screen.Login.route){
                LoginScreen{
                    Log.i("WarpShuttle","LoginScreen")
                }
            }
        }
    }

    private fun NavController.navigator(route: String, clearBackStack: Boolean = false) {
        if (clearBackStack) {
            this.popBackStack()
        }
        navigate(route) {
            launchSingleTop = true
            restoreState = true
        }
    }
}