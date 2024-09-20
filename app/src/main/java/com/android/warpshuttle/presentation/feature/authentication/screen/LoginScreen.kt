package com.android.warpshuttle.presentation.feature.authentication.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.android.warpshuttle.presentation.ui.theme.AppTheme

@Composable
fun LoginScreen(onLogInClicked: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppTheme.colors.colorLightGray)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "Log In",
            textAlign = TextAlign.Start,
            style = AppTheme.typography.header32.copy(AppTheme.colors.colorBlack),
            modifier = Modifier.padding(0.dp,50.dp).fillMaxWidth()
        )
    }
}