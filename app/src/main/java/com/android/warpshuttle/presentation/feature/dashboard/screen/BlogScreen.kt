package com.android.warpshuttle.presentation.feature.dashboard.screen

import android.net.Uri
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.android.warpshuttle.presentation.feature.dashboard.component.DashboardComponent
import com.android.warpshuttle.presentation.ui.component.ComponentClass
import com.android.warpshuttle.presentation.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BlogScreen() {
    var showDialog by remember { mutableStateOf(false) }



    Scaffold(
        containerColor = AppTheme.colors.colorWhite,
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = AppTheme.colors.colorWhite,
                    titleContentColor = AppTheme.colors.colorBlack,
                ),
                title = {
                    Text(
                        text = "Blogs",
                        textAlign = TextAlign.Center,
                        style = AppTheme.typography.h3.copy(color = AppTheme.colors.colorBlack),
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                },
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.clip(CircleShape),
                containerColor = AppTheme.colors.colorBrightBlue,
                contentColor = AppTheme.colors.colorWhite,
                onClick = { showDialog = true }) {
                Icon(imageVector = Icons.Default.Edit, contentDescription = "add")
            }
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
                    ComponentClass.BlogViewItem()
                    ComponentClass.BlogViewItem()
                    ComponentClass.BlogViewItem()
                    ComponentClass.BlogViewItem()
                    ComponentClass.BlogViewItem()
                    ComponentClass.BlogViewItem()
                    ComponentClass.BlogViewItem()
                    ComponentClass.BlogViewItem()
                    ComponentClass.BlogViewItem()
                    ComponentClass.BlogViewItem()
                }
            }
        }
    )


    if (showDialog) {

        DashboardComponent.AddOrEditBlogPopupDialog(
            onDismiss = { showDialog = false },
            onSend = { description, imageUri ->
                // Handle the result
                // imageUri -> selected image
                // description -> user input text
            }
        )
    }
}