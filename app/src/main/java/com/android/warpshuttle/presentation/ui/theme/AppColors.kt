package com.android.warpshuttle.presentation.ui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

class AppColors(
    primary: Color,
    secondary: Color,
    textPrimary: Color,
    textSecondary: Color,
    background: Color,
    onSurface: Color,
    error: Color,
    isLight: Boolean
) {
    private var primary by mutableStateOf(primary)
    private var secondary by mutableStateOf(secondary)
    private var textSecondary by mutableStateOf(textSecondary)
    private var textPrimary by mutableStateOf(textPrimary)
    private var error by mutableStateOf(error)
    private var background by mutableStateOf(background)
    private var onSurface by mutableStateOf(onSurface)
    private var isLight by mutableStateOf(isLight)

    val colorBrightBlue = Color(0xFF2222FB)
    val colorDeepBlue = Color(0xFF2203B1)
    val colorShadowGrey = Color(0xFF191919)
    val colorWhite = Color(0xFFFFFFFF)
    val colorBlack = Color(0xFF000000)

    fun copy(
        primary: Color = this.primary,
        secondary: Color = this.secondary,
        textPrimary: Color = this.textPrimary,
        textSecondary: Color = this.textSecondary,
        error: Color = this.error,
        background: Color = this.background,
        onSurface: Color = this.onSurface,
        isLight: Boolean = this.isLight
    ): AppColors = AppColors(
        primary,
        secondary,
        textPrimary,
        textSecondary,
        error,
        background,
        onSurface,
        isLight
    )

    fun updateColorsFrom(other: AppColors) {
        primary = other.primary
        secondary = other.secondary
        textPrimary = other.textPrimary
        textSecondary = other.textSecondary
        background = other.background
        onSurface = other.onSurface
        error = other.error
    }
}

val ColorWhite = Color(0xFFFFFFFF)
val ColorBlack = Color(0xFF000000)

val ColorBrightBlue = Color(0xFF2222FB)
val ColorDeepBlue = Color(0xFF2203B1)
val ColorShadowGrey = Color(0xFF191919)

private val colorLightPrimary = ColorBrightBlue
private val colorLightSecondary = ColorDeepBlue
private val colorLightTextPrimary = Color(0xFF000000)
private val colorLightTextSecondary = Color(0xFF6C727A)
private val colorLightBackground = Color(0xFFFFFFFF)
private val colorLightError = Color(0xFFD62222)

private val colorDarkPrimary = ColorBrightBlue
private val colorDarkSecondary = ColorDeepBlue
private val colorDarkTextPrimary = Color(0xFFFAFAFA)
private val colorDarkTextSecondary = Color(0xFF6C727A)
private val colorDarkBackground = Color(0xFF090A0A)
private val colorDarkError = Color(0xFFD62222)

fun lightColors(
    primary: Color = colorLightPrimary,
    secondary: Color = colorLightSecondary,
    textPrimary: Color = colorLightTextPrimary,
    textSecondary: Color = colorLightTextSecondary,
    background: Color = colorLightBackground,
    onSurface: Color = ColorBlack,
    error: Color = colorLightError
): AppColors = AppColors(
    primary = primary,
    secondary = secondary,
    textPrimary = textPrimary,
    textSecondary = textSecondary,
    background = background,
    onSurface = onSurface,
    error = error,
    isLight = true
)

fun darkColors(
    primary: Color = colorDarkPrimary,
    secondary: Color = colorDarkSecondary,
    textPrimary: Color = colorDarkTextPrimary,
    textSecondary: Color = colorDarkTextSecondary,
    background: Color = colorDarkBackground,
    onSurface: Color = ColorWhite,
    error: Color = colorDarkError
): AppColors = AppColors(
    primary = primary,
    secondary = secondary,
    textPrimary = textPrimary,
    textSecondary = textSecondary,
    background = background,
    onSurface = onSurface,
    error = error,
    isLight = false
)

val LocalColors = staticCompositionLocalOf { lightColors() }


