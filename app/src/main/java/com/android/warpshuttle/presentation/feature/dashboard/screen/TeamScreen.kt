package com.android.warpshuttle.presentation.feature.dashboard.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.android.warpshuttle.presentation.ui.component.ComponentClass
import com.android.warpshuttle.presentation.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TeamScreen() {
    Scaffold(
        containerColor = AppTheme.colors.colorWhite,
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = AppTheme.colors.colorWhite,
                    titleContentColor = AppTheme.colors.colorBlack,
                ),
                title = {
                   Text(
                        text = "Our Team",
                        textAlign = TextAlign.Center,
                        style = AppTheme.typography.h3.copy(color = AppTheme.colors.colorBlack)
                    )
                },
                actions = {

                },
            )
        },
        floatingActionButton = {

        },
        bottomBar = {

        },
        content = { paddingValues ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(horizontal = 12.dp, vertical = 12.dp),
            ) {
                item {
                    ComponentClass.TeamViewItem()
                    ComponentClass.TeamViewItem()
                    ComponentClass.TeamViewItem()
                    ComponentClass.TeamViewItem()
                    ComponentClass.TeamViewItem()
                    ComponentClass.TeamViewItem()
                    ComponentClass.TeamViewItem()
                    ComponentClass.TeamViewItem()
                    ComponentClass.TeamViewItem()
                    ComponentClass.TeamViewItem()
                    ComponentClass.TeamViewItem()
                    ComponentClass.TeamViewItem()
                }
            }
        }
    )
}