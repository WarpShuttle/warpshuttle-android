package com.android.warpshuttle.presentation.feature.authentication.screen

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animate
import androidx.compose.animation.core.repeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.android.warpshuttle.presentation.ui.component.ComponentClass
import com.android.warpshuttle.presentation.ui.theme.AppTheme
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(
    email: String,
    password: String,
    onEmailValueChange: (String) -> Unit,
    onPasswordValueChange: (String) -> Unit,
    onLogInClicked: () -> Unit
) {

    var emailOffsetX by remember {
        mutableFloatStateOf(0f)
    }

    var passwordOffsetX by remember {
        mutableFloatStateOf(0f)
    }

    val coroutineScope = rememberCoroutineScope()

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
            modifier = Modifier
                .weight(0.2f)
                .padding(
                    AppTheme.dimens.dimens_20,
                    AppTheme.dimens.dimens_90,
                    AppTheme.dimens.dimens_20,
                    AppTheme.dimens.dimens_20
                )
                .fillMaxWidth()
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.8f)
                .clip(
                    shape = RoundedCornerShape(
                        AppTheme.dimens.dimens_15,
                        AppTheme.dimens.dimens_15
                    )
                )
                .background(AppTheme.colors.colorWhite)
                .padding(
                    start = AppTheme.dimens.dimens_20,
                    top = AppTheme.dimens.dimens_40,
                    end = AppTheme.dimens.dimens_20,
                )
        ) {
            Text(
                text = "Your Email",
                textAlign = TextAlign.Start,
                style = AppTheme.typography.captionRegular.copy(color = AppTheme.colors.colorGray),
                modifier = Modifier.padding(bottom = AppTheme.dimens.dimens_12)
            )

            ComponentClass.WarpTextField(
                defaultValue = email,
                placeholderText = "Enter your email",
                placeHolderColor = AppTheme.colors.colorGray,
                buttonOffsetX = emailOffsetX.dp,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                ),
                onValueChange = onEmailValueChange
            )

            Text(
                text = "Password",
                textAlign = TextAlign.Start,
                style = AppTheme.typography.captionRegular.copy(color = AppTheme.colors.colorGray),
                modifier = Modifier.padding(
                    top = AppTheme.dimens.dimens_26,
                    bottom = AppTheme.dimens.dimens_12
                )
            )

            ComponentClass.WarpTextField(
                defaultValue = password,
                placeholderText = "Enter your password",
                placeHolderColor = AppTheme.colors.colorGray,
                buttonOffsetX = passwordOffsetX.dp,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                ),
                onValueChange = onPasswordValueChange
            )

            Text(
                text = "Forgot password?",
                textAlign = TextAlign.End,
                style = AppTheme.typography.subtitle1.copy(color = AppTheme.colors.colorGray),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = AppTheme.dimens.dimens_20, bottom = AppTheme.dimens.dimens_12)
            )

            ComponentClass.WarpButton(
                title = "Log In",
                isValid = false,
                type = "bluishType",
                modifier = Modifier.padding(top = AppTheme.dimens.dimens_20)
            ) {
                if (email.isEmpty()) {
                    coroutineScope.launch {
                        animate(
                            initialValue = -5f,
                            targetValue = 5f,
                            animationSpec = repeatable(
                                4,
                                repeatMode = RepeatMode.Reverse,
                                animation = tween(80, easing = LinearEasing)
                            )
                        ) { value, _ ->
                            emailOffsetX = value
                        }
                    }
                } else if (password.isEmpty()) {
                    coroutineScope.launch {
                        animate(
                            initialValue = -5f,
                            targetValue = 5f,
                            animationSpec = repeatable(
                                4,
                                repeatMode = RepeatMode.Reverse,
                                animation = tween(80, easing = LinearEasing)
                            )
                        ) { value, _ ->
                            passwordOffsetX = value
                        }
                    }
                } else {
                    onLogInClicked()
                }
            }

        }
    }
}