package com.android.warpshuttle.presentation.feature.authentication.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import com.android.warpshuttle.presentation.ui.theme.AppColors
import com.android.warpshuttle.presentation.ui.theme.AppTheme

@Composable
fun LoginScreen(onDone: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Login Screen",
            style = AppTheme.typography.h1Bold24.copy(AppTheme.colors.colorBlack)
        )
        Text(
            text = "Login Screen",
            style = AppTheme.typography.h1Normal24.copy(AppTheme.colors.colorBlack)
        )
        Text(
            text = "Login Screen",
            style = AppTheme.typography.h4.copy(AppTheme.colors.colorBlack)
        )
        Text(
            text = "Login Screen",
            style = AppTheme.typography.h5.copy(AppTheme.colors.colorBlack)
        )
    }
}