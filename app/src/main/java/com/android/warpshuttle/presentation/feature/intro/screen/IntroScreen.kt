package com.android.warpshuttle.presentation.feature.intro.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.warpshuttle.R
import com.android.warpshuttle.presentation.ui.component.WarpButton
import com.android.warpshuttle.presentation.ui.theme.AppTheme
import kotlinx.coroutines.launch

@Composable
fun IntroScreen() {
    val greetings = listOf(
        Triple(
            R.drawable.ic_warpshuttle,
            "Welcome to Warp Shuttle!",
            "Get all your loved foods in one once place"
        ),
        Triple(
            R.drawable.ic_warpshuttle,
            "Welcome to Warp Shuttle!",
            "Get all your loved foods in one once place, you just place the orer we do the rest"
        ),
        Triple(
            R.drawable.ic_warpshuttle,
            "Welcome to Warp Shuttle!",
            "Get all your loved foods in one once place, lorem"
        ),
        Triple(
            R.drawable.ic_warpshuttle,
            "Welcome to Warp Shuttle!",
            "Get all your loved foods in one once place,ipsum"
        )
    )

    var buttonName by rememberSaveable { mutableStateOf("Get Started") }
    var visibleSkip by remember { mutableStateOf(true) }

    val pagerState = rememberPagerState { greetings.size }
    val scope = rememberCoroutineScope()

    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }.collect { page ->
            if (page < 3) {
                visibleSkip = true
                buttonName = "Next"
            } else {
                visibleSkip = false
                buttonName = "Get Started"
            }
        }
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 24.dp, bottom = 16.dp)
    ) {

        HorizontalPager(
            modifier = Modifier.weight(1f),
            state = pagerState,
            key = { greetings[it] },
            pageSize = PageSize.Fill
        ) {
            ItemGreeting(greetings[it])
        }

        Spacer(modifier = Modifier.height(32.dp))

        DotsIndicator(
            totalDots = greetings.size,
            selectedIndex = pagerState.currentPage,
            selectedColor = AppTheme.colors.colorDeepBlue,
            unSelectedColor = AppTheme.colors.colorGray,
        )

        Spacer(modifier = Modifier.height(64.dp))

        WarpButton(
            title = buttonName,
            modifier = Modifier
                .padding(start = 24.dp, end = 24.dp)
                .width(175.dp)
        ) {
            if (pagerState.currentPage == 0 || pagerState.currentPage < 3) {
                scope.launch {
                    pagerState.animateScrollToPage(
                        pagerState.currentPage + 1
                    )
                }
            } else {
                //start app
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (visibleSkip)
            Text(
                text = "Skip",
                modifier = Modifier
                    .height(48.dp)
                    .padding(horizontal = 12.dp, vertical = 12.dp)
                    .clickable {
//                        navController?.navigate(Screen.Login.route) {
//
//                        }
                    },
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                color = AppTheme.colors.colorBlack
            )
        else Spacer(modifier = Modifier.height(48.dp))


    }
}

@Composable
fun ItemGreeting(item: Triple<Int, String, String>) {

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(start = 24.dp, end = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Icon(
            painter = painterResource(id = item.first),
            contentDescription = "image",
            modifier = Modifier
                .height(130.dp)
                .width(130.dp)
                .clip(RoundedCornerShape(10.dp)),
            tint = AppTheme.colors.colorBrightBlue
        )

        Spacer(modifier = Modifier.height(64.dp))

        Text(
            text = item.second,
            fontSize = 24.sp,
            color = AppTheme.colors.colorBlack
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = item.third,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            color = AppTheme.colors.colorShadowGrey
        )
    }
}

@Composable
fun DotsIndicator(
    totalDots: Int,
    selectedIndex: Int,
    selectedColor: Color,
    unSelectedColor: Color,
) {

    LazyRow(
        modifier = Modifier
            .wrapContentWidth()
            .wrapContentHeight()

    ) {

        items(totalDots) { index ->
            if (index == selectedIndex) {
                Box(
                    modifier = Modifier
                        .size(width = 20.dp, height = 8.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(selectedColor)
                )
            } else {
                Box(
                    modifier = Modifier
                        .size(width = 12.dp, height = 8.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(unSelectedColor)
                )
            }

            if (index != totalDots - 1) {
                Spacer(modifier = Modifier.padding(horizontal = 5.dp))
            }
        }
    }
}