package com.android.warpshuttle.presentation.feature.dashboard.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.android.warpshuttle.presentation.feature.dashboard.component.DashboardComponent
import com.android.warpshuttle.presentation.ui.theme.AppTheme
import com.android.warpshuttle.R
import com.android.warpshuttle.data.enums.ViewType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen() {
    val navController = rememberNavController()
    Scaffold(
        containerColor = AppTheme.colors.colorWhite,
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Account",
                        textAlign = TextAlign.Center,
                        style = AppTheme.typography.h3.copy(color = AppTheme.colors.colorBlack),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /* doSomething() */ }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                actions = {

                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = AppTheme.colors.colorWhite,
                    titleContentColor = AppTheme.colors.colorBlack,
                ),
            )
        },
        floatingActionButton = {

        },
        bottomBar = {

        },
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(horizontal = 0.dp, vertical = 12.dp),
            ) {
              DashboardComponent.ProfileView(modifier = Modifier, data = R.drawable.ic_dummy_banner, viewType = ViewType.TEAMVIEW.type)
            }
        }
    )
}