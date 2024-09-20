package com.android.warpshuttle.presentation.ui.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.android.warpshuttle.R
import com.android.warpshuttle.presentation.ui.theme.AppTheme

@Composable
fun WarpTextField(
    modifier: Modifier = Modifier,
    defaultValue: String,
    placeholderText: String,
    placeHolderColor: Color = AppTheme.colors.colorDeepBlue,
    buttonOffsetX: Dp,
    textLength: Int = Int.MAX_VALUE,
    keyboardOptions: KeyboardOptions,
    onValueChanged: (String) -> Unit
) {
    val focusManager = LocalFocusManager.current
    var nameFieldValue by remember { mutableStateOf(defaultValue) }
    TextField(
        value = nameFieldValue,
        onValueChange = {
            if (it.length <= textLength) {
                nameFieldValue = it
                onValueChanged.invoke(it)
            }
        },
        modifier = modifier
            .fillMaxWidth()
            .offset(x = buttonOffsetX, y = 0.dp)
            .border(
                width = 1.dp,
                brush = Brush.horizontalGradient(listOf(AppTheme.colors.colorGray, AppTheme.colors.colorGray)),
                shape = RoundedCornerShape(AppTheme.dimens.dimens_15)
            ),
        colors = TextFieldDefaults.textFieldColors(
            textColor = colorResource(id = R.color.black),
            backgroundColor = colorResource(
                id = R.color.white
            ),
            cursorColor = AppTheme.colors.colorBrightBlue,
            disabledIndicatorColor = AppTheme.colors.colorShadowGrey,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        placeholder = {
            Text(
                placeholderText,
                style = AppTheme.typography.h5.copy(placeHolderColor),
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth()
            )
        },
        maxLines = 1,
        shape = RoundedCornerShape(AppTheme.dimens.dimens_15),
        textStyle = AppTheme.typography.h5.copy(textAlign = TextAlign.Start, color = AppTheme.colors.colorBlack),
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            capitalization = KeyboardCapitalization.Sentences,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(onDone = {
            focusManager.clearFocus()
        }),
    )
}