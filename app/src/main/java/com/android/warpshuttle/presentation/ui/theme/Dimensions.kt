package com.android.warpshuttle.presentation.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class Dimensions(
    val dimens_12: Dp,
    val dimens_15: Dp,
    val dimens_18: Dp,
    val dimens_20: Dp,
    val dimens_26: Dp,
    val dimens_30: Dp,
    val dimens_40: Dp,
    val dimens_50: Dp,
    val dimens_75: Dp,
    val dimens_90: Dp,
    val dimens_100: Dp,
    val dimens_120: Dp,
    val dimens_160: Dp
)

val smallDimension = Dimensions(
    dimens_12 = 10.dp,
    dimens_15 = 12.dp,
    dimens_18 = 14.dp,
    dimens_20 = 15.dp,
    dimens_26 = 22.dp,
    dimens_30 = 26.dp,
    dimens_40 = 30.dp,
    dimens_50 = 40.dp,
    dimens_75 = 60.dp,
    dimens_90 = 75.dp,
    dimens_100 = 85.dp,
    dimens_120 = 0.dp,
    dimens_160 = 140.dp,
)

val sw420Dimension = Dimensions(
    dimens_12 = 12.dp,
    dimens_15 = 15.dp,
    dimens_18 = 18.dp,
    dimens_20 = 20.dp,
    dimens_26 = 26.dp,
    dimens_30 = 30.dp,
    dimens_40 = 40.dp,
    dimens_50 = 50.dp,
    dimens_75 = 75.dp,
    dimens_90 = 90.dp,
    dimens_100 = 100.dp,
    dimens_120 = 120.dp,
    dimens_160 = 160.dp
)

val textSmallDimension = AppTypography(
    header32 = TextStyle(
        fontFamily = TTCommonFonts,
        fontWeight = FontWeight.Bold,
        lineHeight = 30.sp,
        fontSize = 28.sp
    ),
    header30 = TextStyle(
        fontFamily = TTCommonFonts,
        fontWeight = FontWeight.Bold,
        lineHeight = 34.sp,
        fontSize = 26.sp
    ),
    header30Normal = TextStyle(
        fontFamily = TTCommonFonts,
        fontWeight = FontWeight.Normal,
        lineHeight = 34.sp,
        fontSize = 26.sp
    ),
    h1Bold28 = TextStyle(
        fontFamily = TTCommonFonts,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    ),
    h1Normal26 = TextStyle(
        fontFamily = TTCommonFonts,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp
    ),
    h1Bold24 = TextStyle(
        fontFamily = TTCommonFonts,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),
    h1Normal24 = TextStyle(
        fontFamily = TTCommonFonts,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp
    ),
    bold22 = TextStyle(
        fontFamily = TTCommonFonts,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    ),
    normal22 = TextStyle(
        fontFamily = TTCommonFonts,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp
    ),
    h2Bold20 = TextStyle(
        fontFamily = TTCommonFonts,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    ),
    h2Normal20 = TextStyle(
        fontFamily = TTCommonFonts,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    h3Bold18 = TextStyle(
        fontFamily = TTCommonFonts,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    ),
    h3Normal18 = TextStyle(
        fontFamily = TTCommonFonts,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    h4Bold16 = TextStyle(
        fontFamily = TTCommonFonts,
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp
    ),
    h4Normal16 = TextStyle(
        fontFamily = TTCommonFonts,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    h5Normal14 = TextStyle(
        fontFamily = TTCommonFonts,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    h5Bold14 = TextStyle(
        fontFamily = TTCommonFonts,
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp
    )
)

val textSw420Dimensions = AppTypography(
    header32 = TextStyle(
        fontFamily = TTCommonFonts,
        fontWeight = FontWeight.Bold,
        lineHeight = 34.sp,
        fontSize = 32.sp
    ),
    header30 = TextStyle(
        fontFamily = TTCommonFonts,
        fontWeight = FontWeight.Bold,
        lineHeight = 34.sp,
        fontSize = 30.sp
    ),
    header30Normal = TextStyle(
        fontFamily = TTCommonFonts,
        fontWeight = FontWeight.Normal,
        lineHeight = 34.sp,
        fontSize = 30.sp
    ),
    h1Bold28 = TextStyle(
        fontFamily = TTCommonFonts,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp
    ),
    h1Normal26 = TextStyle(
        fontFamily = TTCommonFonts,
        fontWeight = FontWeight.Normal,
        fontSize = 26.sp
    ),
    h1Bold24 = TextStyle(
        fontFamily = TTCommonFonts,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    ),
    h1Normal24 = TextStyle(
        fontFamily = TTCommonFonts,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp
    ),
    bold22 = TextStyle(
        fontFamily = TTCommonFonts,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp
    ),
    normal22 = TextStyle(
        fontFamily = TTCommonFonts,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp
    ),
    h2Bold20 = TextStyle(
        fontFamily = TTCommonFonts,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),
    h2Normal20 = TextStyle(
        fontFamily = TTCommonFonts,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp
    ),
    h3Bold18 = TextStyle(
        fontFamily = TTCommonFonts,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    ),
    h3Normal18 = TextStyle(
        fontFamily = TTCommonFonts,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp
    ),
    h4Bold16 = TextStyle(
        fontFamily = TTCommonFonts,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    ),
    h4Normal16 = TextStyle(
        fontFamily = TTCommonFonts,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    h5Normal14 = TextStyle(
        fontFamily = TTCommonFonts,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    h5Bold14 = TextStyle(
        fontFamily = TTCommonFonts,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    )
)