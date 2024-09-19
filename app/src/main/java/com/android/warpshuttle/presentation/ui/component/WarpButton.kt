package com.android.warpshuttle.presentation.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.unit.dp
import com.android.warpshuttle.presentation.ui.theme.AppTheme

@Composable
fun WarpButton(
    title: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    val hapticFeedback = LocalHapticFeedback.current

    Button(
        modifier = modifier
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