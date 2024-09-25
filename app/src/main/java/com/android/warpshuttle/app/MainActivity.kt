package com.android.warpshuttle.app

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.core.view.WindowCompat
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.android.warpshuttle.data.network.RemoteDataService
import com.android.warpshuttle.data.repository.UserRepository
import com.android.warpshuttle.navigation.Screen
import com.android.warpshuttle.navigation.customAnimatedComposable
import com.android.warpshuttle.navigation.rememberCustomAnimatedNavController
import com.android.warpshuttle.presentation.feature.authentication.screen.LoginScreen
import com.android.warpshuttle.presentation.feature.authentication.viewmodel.LoginViewModel
import com.android.warpshuttle.presentation.feature.dashboard.screen.DashboardScreen
import com.android.warpshuttle.presentation.feature.intro.screen.IntroScreen
import com.android.warpshuttle.presentation.feature.intro.viewmodel.IntroViewModel
import com.android.warpshuttle.presentation.feature.splashscreen.SplashScreen
import com.android.warpshuttle.presentation.ui.theme.AnimatedSplashScreenTheme

class MainActivity : AppCompatActivity() {
    private var navController: NavHostController? = null

    private val introViewModel by viewModels<IntroViewModel> {
        IntroViewModel.ViewModelFactory(
            userRepository = UserRepository.getInstance(
                RemoteDataService().getApiService(),
                null,
                this
            )
        )
    }

    private val loginViewModel by viewModels<LoginViewModel> {
        LoginViewModel.ViewModelFactory(
            userRepository = UserRepository.getInstance(
                RemoteDataService().getApiService(),
                null,
                this
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        WindowCompat.setDecorFitsSystemWindows(window, false)

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
        val isLoggedIn by loginViewModel.isLoggedIn.observeAsState()
        val email by loginViewModel.email.collectAsState()
        val password by loginViewModel.password.collectAsState()

        NavHost(
            navController = navController,
            startDestination = Screen.Splash.route
        ) {
            customAnimatedComposable(route = Screen.Splash.route) {
                SplashScreen {
                    if (isLoggedIn == true) {
                        navController.navigator(Screen.Dashboard.route, clearBackStack = true)
                    } else {
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
                LoginScreen(
                    email = email,
                    password = password,
                    onEmailValueChange = { newEmail -> loginViewModel.updateEmail(newEmail) },
                    onPasswordValueChange = { newPassword ->
                        loginViewModel.updatePassword(newPassword)
                    }) {
                    verifyLogin(email, password)
                }
            }

            customAnimatedComposable(route = Screen.Dashboard.route) {
                DashboardScreen()
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

    private fun verifyLogin(email: String, password: String) {
        loginViewModel.verifyLogin(
            email,
            password
        ).observe(this) { responseEvent ->
            when {
                responseEvent.isLoading -> {}

                responseEvent.isSuccess -> {
                    loginViewModel.updateLogInStatus(true)
                    navController?.navigator(Screen.Dashboard.route, clearBackStack = true)
                }

                else -> {

                }
            }
        }
    }
}