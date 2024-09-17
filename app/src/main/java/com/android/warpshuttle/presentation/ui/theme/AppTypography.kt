package com.android.warpshuttle.presentation.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

data class AppTypography(
    val header32: TextStyle,

    val header30: TextStyle,

    val header30Normal: TextStyle,

    val h1Bold28: TextStyle,

    val h1Normal26: TextStyle,

    val h1Bold24: TextStyle,

    val h1Normal24: TextStyle,

    val bold22: TextStyle,

    val normal22: TextStyle,

    val h2Bold20: TextStyle,

    val h2Normal20: TextStyle,

    val h3Bold18: TextStyle,

    val h3Normal18: TextStyle,

    val h4Bold16: TextStyle,

    val h4Normal16: TextStyle,

    val h5Normal14: TextStyle,

    val h5Bold14: TextStyle,

    val h1: TextStyle = TextStyle(
        fontFamily = PoppinsFont,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp
    ),

    val h2: TextStyle = TextStyle(
        fontFamily = PoppinsFont,
        fontWeight = FontWeight.Bold,
        fontSize = 21.sp
    ),

    val h3: TextStyle = TextStyle(
        fontFamily = PoppinsFont,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    ),
    val h4: TextStyle = TextStyle(
        fontFamily = PoppinsFont,
        fontWeight = FontWeight.Medium,
        fontSize = 15.sp
    ),
    val h5: TextStyle = TextStyle(
        fontFamily = PoppinsFont,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp
    ),
    val h6: TextStyle = TextStyle(
        fontFamily = PoppinsFont,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    ),
    val body1: TextStyle = TextStyle(
        fontFamily = PoppinsFont,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    val body2: TextStyle = TextStyle(
        fontFamily = PoppinsFont,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    ),
    val subtitle1: TextStyle = TextStyle(
        fontFamily = PoppinsFont,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    ),
    val button: TextStyle = TextStyle(
        fontFamily = PoppinsFont,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    ),
    val caption: TextStyle = TextStyle(
        fontFamily = PoppinsFont,
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp
    ),
    val caption11sp: TextStyle = TextStyle(
        fontFamily = PoppinsFont,
        fontWeight = FontWeight.Bold,
        fontSize = 11.sp
    ),
    val captionRegular: TextStyle = TextStyle(
        fontFamily = PoppinsFont,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    val bigText: TextStyle = TextStyle(
        fontFamily = PoppinsFont,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp
    ),

    /*----------------------------------------------------*/
    val header: TextStyle = TextStyle(
        fontFamily = PoppinsFont,
        fontWeight = FontWeight.Bold,
        lineHeight = 34.sp,
        fontSize = 30.sp
    ),
    val subHeader: TextStyle = TextStyle(
        fontFamily = PoppinsFont,
        fontWeight = FontWeight.Normal,
        lineHeight = 24.sp,
        fontSize = 20.sp
    ),
    val subHeaderBold: TextStyle = TextStyle(
        fontFamily = PoppinsFont,
        fontWeight = FontWeight.Bold,
        lineHeight = 24.sp,
        fontSize = 20.sp
    ),
    val textField: TextStyle = TextStyle(
        fontFamily = PoppinsFont,
        fontWeight = FontWeight.Bold,
        lineHeight = 30.sp,
        fontSize = 25.sp
    ),
    val buttonNext: TextStyle = TextStyle(
        fontFamily = PoppinsFont,
        fontWeight = FontWeight.Bold,
        lineHeight = 26.sp,
        fontSize = 19.sp
    ),
    val contentBlockHeader: TextStyle = TextStyle(
        fontFamily = PoppinsFont,
        fontWeight = FontWeight.Bold,
        lineHeight = 40.sp,
        fontSize = 32.sp
    ),
    val contentBlockSubHeader: TextStyle = TextStyle(
        fontFamily = PoppinsFont,
        fontWeight = FontWeight.Bold,
        lineHeight = 25.sp,
        fontSize = 22.sp
    ),
    val contentBlockText: TextStyle = TextStyle(
        fontFamily = PoppinsFont,
        fontWeight = FontWeight.Normal,
        lineHeight = 23.sp,
        fontSize = 16.sp
    ),
    val caption10Bold: TextStyle = TextStyle(
        fontFamily = PoppinsFont,
        fontWeight = FontWeight.Bold,
        lineHeight = 12.sp,
        fontSize = 10.sp
    )
)

