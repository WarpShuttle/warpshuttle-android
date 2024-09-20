package com.android.warpshuttle.app

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.android.warpshuttle.data.repository.UserRepository
import com.android.warpshuttle.navigation.Screen
import com.android.warpshuttle.navigation.customAnimatedComposable
import com.android.warpshuttle.navigation.rememberCustomAnimatedNavController
import com.android.warpshuttle.presentation.feature.authentication.screen.LoginScreen
import com.android.warpshuttle.presentation.feature.intro.screen.IntroScreen
import com.android.warpshuttle.presentation.feature.intro.viewmodel.IntroViewModel
import com.android.warpshuttle.presentation.feature.splashscreen.SplashScreen
import com.android.warpshuttle.presentation.ui.theme.AnimatedSplashScreenTheme

class MainActivity : AppCompatActivity() {
    private var navController: NavHostController? = null

    private val introViewModel by viewModels<IntroViewModel> {
        IntroViewModel.ViewModelFactory(userRepository = UserRepository.getInstance(this))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AnimatedSplashScreenTheme {
                navController = rememberCustomAnimatedNavController()
                SetupNavGraph(navController = navController!!)
            }
        }
    }

    @Composable
    fun SetupNavGraph(navController: NavHostController) {
        val isIntroViewed by introViewModel.isIntroViewed.observeAsState()

        NavHost(
            navController = navController,
            startDestination = Screen.Splash.route
        ) {
            customAnimatedComposable(route = Screen.Splash.route) {
                SplashScreen {
                    if (isIntroViewed == true) {
                        navController.navigator(
                            Screen.Login.route,
                            clearBackStack = true
                        )
                    } else {
                        navController.navigator(
                            Screen.Intro.route,
                            clearBackStack = true
                        )
                    }
                }
            }

            customAnimatedComposable(route = Screen.Intro.route) {
                IntroScreen(getStartedClicked = {
                    introViewModel.updateIsIntroViewedStatus(true)
                    navController.navigator(
                        Screen.Login.route, clearBackStack = true
                    )
                }) {
                    introViewModel.updateIsIntroViewedStatus(true)
                    navController.navigator(
                        Screen.Login.route, clearBackStack = true
                    )
                }
            }

            customAnimatedComposable(route = Screen.Login.route) {
                LoginScreen {
                    Log.i("WarpShuttle", "LoginScreen")
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