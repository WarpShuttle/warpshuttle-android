package com.android.warpshuttle.presentation.ui.component

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.unit.dp
import com.android.warpshuttle.presentation.ui.theme.AppTheme

fun Modifier.bounceClickEffect() = composed {
    var isPressed by remember { mutableStateOf(false) }
    val scale by animateFloatAsState(if (isPressed) 0.70f else 1f, label = "")

    this
        .graphicsLayer {
            scaleX = scale
            scaleY = scale
        }
        .pointerInput(isPressed) {
            awaitPointerEventScope {
                isPressed = if (isPressed) {
                    waitForUpOrCancellation()
                    false
                } else {
                    awaitFirstDown(false)
                    true
                }
            }
        }
}

@Composable
fun WarpButton(
    title: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    val hapticFeedback = LocalHapticFeedback.current

    Button(
        modifier = modifier
            .bounceClickEffect()
            .fillMaxWidth()
            .height(50.dp),
        shape = RoundedCornerShape(20),
        colors = ButtonDefaults.textButtonColors(AppTheme.colors.colorBrightBlue),
        onClick = {
            hapticFeedback.performHapticFeedback(HapticFeedbackType.LongPress)
            onClick()
        }) {
        Text(
            text = title,
            style = AppTheme.typography.h3.copy(AppTheme.colors.colorWhite)
        )
    }
}