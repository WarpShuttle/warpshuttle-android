package com.android.warpshuttle.presentation.feature.dashboard.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.android.warpshuttle.R
import com.android.warpshuttle.presentation.ui.component.ComponentClass
import com.android.warpshuttle.presentation.ui.theme.AppTheme

@Composable
fun HomeScreen(onProfileViewClicked: () -> Unit) {
    Column() {
        HomeScreenBlock(modifier = Modifier.weight(0.30f)) {
            onProfileViewClicked()
        }

        Column(
            modifier = Modifier
                .background(AppTheme.colors.colorWhite)
                .fillMaxSize()
                .weight(0.70f)
        ) {
            LazyColumn(
                modifier = Modifier
                    .weight(0.70f)
                    .fillMaxSize()
                    .padding(horizontal = AppTheme.dimens.dimens_12)
                    .padding(bottom = AppTheme.dimens.dimens_12),
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
                }
            }

            Column(
                modifier = Modifier
                    .weight(0.30f)
                    .fillMaxWidth()
            ) {
                ComponentClass.WarpButton(
                    title = "Schedule Leave",
                    isValid = true,
                    type = "transparencyType",
                    modifier = Modifier.padding(horizontal = AppTheme.dimens.dimens_12)
                ) {

                }

                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.padding(
                        horizontal = AppTheme.dimens.dimens_12,
                        vertical = AppTheme.dimens.dimens_12
                    )
                ) {
                    ComponentClass.WarpButton(
                        title = "Clock In",
                        isValid = true,
                        type = "bluishType",
                        modifier = Modifier
                            .width(175.dp)
                            .padding(end = 6.dp)
                    ) {

                    }
                    ComponentClass.WarpButton(
                        title = "Clock Out",
                        isValid = false,
                        type = "greyishType",
                        modifier = Modifier
                            .width(175.dp)
                            .padding(start = 6.dp)
                    ) {

                    }
                }
            }
        }
    }
}

@Composable
fun OverlappingBoxes(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Layout(
        modifier = modifier,
        content = content,
    ) { measurables, constraints ->
        val largeBox = measurables[0]
        val smallBox = measurables[1]
        val looseConstraints = constraints.copy(
            minWidth = 0,
            minHeight = 0,
        )
        val largePlaceable = largeBox.measure(looseConstraints)
        val smallPlaceable = smallBox.measure(looseConstraints)
        layout(
            width = constraints.maxWidth,
            height = largePlaceable.height + smallPlaceable.height,
        ) {
            largePlaceable.placeRelative(
                x = 0,
                y = 0,
            )
            smallPlaceable.placeRelative(
                x = (constraints.maxWidth - smallPlaceable.width) / 2,
                y = largePlaceable.height - smallPlaceable.height / 2
            )
        }
    }
}

@Composable
fun HomeScreenBlock(
    modifier: Modifier = Modifier,
    onProfileImageClicked: () -> Unit
) {
    OverlappingBoxes(modifier = modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier
                .background(AppTheme.colors.colorBrightBlue)
                .wrapContentHeight()
                .fillMaxWidth()
                .height(AppTheme.dimens.dimens_180)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(AppTheme.colors.colorBrightBlue)
                    .padding(
                        start = AppTheme.dimens.dimens_20,
                        top = AppTheme.dimens.dimens_50,
                        end = AppTheme.dimens.dimens_20
                    )
            ) {
                Column(modifier = Modifier.wrapContentWidth()) {
                    Text(
                        text = "Hi! Ronit",
                        textAlign = TextAlign.Start,
                        style = AppTheme.typography.h1.copy(color = AppTheme.colors.colorWhite),
                    )

                    Text(
                        text = "Android Developer",
                        textAlign = TextAlign.Start,
                        style = AppTheme.typography.body1.copy(color = AppTheme.colors.colorWhite),
                        modifier = Modifier
                            .padding(bottom = 5.dp)
                    )
                }

                Box(
                    modifier = Modifier
                        .size(AppTheme.dimens.dimens_50)
                        .clip(RoundedCornerShape(100))
                        .border(
                            width = 2.dp,
                            brush = Brush.horizontalGradient(
                                listOf(
                                    AppTheme.colors.colorWhite,
                                    AppTheme.colors.colorWhite
                                )
                            ),
                            shape = RoundedCornerShape(100)
                        )
                        .clickable { onProfileImageClicked() }
                ) {
                    ComponentClass.ImageItem(
                        modifier = Modifier.fillMaxSize(),
                        data = R.drawable.ic_warpshuttle,
                        contentScale = ContentScale.Crop
                    )
                }
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = AppTheme.dimens.dimens_20)
                .clickable { }
        ) {
            Column(
                modifier = Modifier
                    .shadow(
                        elevation = 10.dp,
                        shape = RoundedCornerShape(AppTheme.dimens.dimens_12)
                    )
                    .background(AppTheme.colors.colorWhite)
                    .padding(
                        horizontal = AppTheme.dimens.dimens_20,
                        vertical = AppTheme.dimens.dimens_20
                    )
                    .fillMaxWidth()
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Attendance List",
                        textAlign = TextAlign.Start,
                        style = AppTheme.typography.body1.copy(color = AppTheme.colors.colorGray),
                        modifier = Modifier
                            .padding(bottom = 5.dp)
                    )
                    Text(
                        text = "View All",
                        textAlign = TextAlign.End,
                        style = AppTheme.typography.captionRegular.copy(color = AppTheme.colors.colorBrightBlue),
                        modifier = Modifier
                            .padding(bottom = 5.dp)
                    )
                }
                Row(
                    modifier = Modifier.padding(bottom = 5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "13",
                        textAlign = TextAlign.Start,
                        style = AppTheme.typography.h3.copy(color = AppTheme.colors.colorBlack),
                    )

                    Text(
                        text = "/24",
                        textAlign = TextAlign.Start,
                        style = AppTheme.typography.body1.copy(color = AppTheme.colors.colorGray),
                    )
                }
            }
        }
    }
}





