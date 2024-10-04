package com.android.warpshuttle.presentation.ui.component

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.request.ImageRequest
import com.android.warpshuttle.presentation.ui.theme.AppTheme
import com.android.warpshuttle.R

object ComponentClass {
    @Composable
    fun TeamViewItem() {
        Card(
            shape = RoundedCornerShape(AppTheme.dimens.dimens_12),
            modifier = Modifier
                .background(AppTheme.colors.colorWhite)
                .padding(bottom = AppTheme.dimens.dimens_12)
                .height(AppTheme.dimens.dimens_100)
                .fillMaxWidth()
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .background(AppTheme.colors.colorCardBlockGray)
                    .fillMaxHeight()
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .weight(0.30f)
                        .padding(horizontal = AppTheme.dimens.dimens_12)
                        .size(width = AppTheme.dimens.dimens_75, height = AppTheme.dimens.dimens_75)

                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_dummy_banner),
                        contentDescription = "profilePicture",
                        modifier = Modifier.clip(RoundedCornerShape(AppTheme.dimens.dimens_12)),
                        contentScale = ContentScale.Crop
                    )
                }

                Column(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .fillMaxWidth()
                        .weight(0.70f)
                        .padding(start = AppTheme.dimens.dimens_12),
                ) {
                    Text(
                        text = "Ronit Prajapati",
                        textAlign = TextAlign.Start,
                        style = AppTheme.typography.body2.copy(color = AppTheme.colors.colorBlack),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 5.dp)
                    )
                    Text(
                        text = "Android Developer",
                        textAlign = TextAlign.Start,
                        style = AppTheme.typography.captionRegular.copy(color = AppTheme.colors.colorGray),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 5.dp)
                    )
                    Text(
                        text = "Present",
                        textAlign = TextAlign.Start,
                        style = AppTheme.typography.captionRegular.copy(color = AppTheme.colors.colorDeepBlue),
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                }
            }
        }
    }

    @Composable
    fun BlogViewItem() {
        Card(
            shape = RoundedCornerShape(AppTheme.dimens.dimens_12),
            modifier = Modifier
                .background(AppTheme.colors.colorWhite)
                .padding(bottom = AppTheme.dimens.dimens_12)
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .background(AppTheme.colors.colorCardBlockGray)
                    .fillMaxWidth()
                    .padding(AppTheme.dimens.dimens_12)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = AppTheme.dimens.dimens_12)
                ) {
                    Text(
                        text = "Blog Title 1",
                        textAlign = TextAlign.Start,
                        style = AppTheme.typography.h6.copy(color = AppTheme.colors.colorBlack),
                        modifier = Modifier
                            .padding(bottom = 5.dp)
                    )

                    Text(
                        text = "Edit Blogs",
                        textAlign = TextAlign.End,
                        style = AppTheme.typography.captionRegular.copy(color = AppTheme.colors.colorBrightBlue),
                        modifier = Modifier
                            .padding(bottom = 5.dp)
                    )
                }

                Text(
                    text = "Blog descriptions Lorem ipsum dolor sit amet, consectetur adispiscing eli, sed do.",
                    textAlign = TextAlign.Start,
                    style = AppTheme.typography.captionRegular.copy(color = AppTheme.colors.colorGray),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = AppTheme.dimens.dimens_12)
                )

                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(AppTheme.dimens.dimens_160)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_dummy_banner),
                        contentDescription = "profilePicture",
                        modifier = Modifier.clip(RoundedCornerShape(AppTheme.dimens.dimens_12)),
                        contentScale = ContentScale.Crop
                    )
                }

            }
        }
    }


    private fun Modifier.bounceClickEffect() = composed {
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
        isValid: Boolean,
        type: String?,
        modifier: Modifier = Modifier,
        onClick: (isValid: Boolean) -> Unit
    ) {
        val hapticFeedback = LocalHapticFeedback.current

        val buttonColors =
            if (type == "bluishType") AppTheme.colors.colorBrightBlue else if (type == "greyishType") AppTheme.colors.colorButtonGray else AppTheme.colors.colorWhite

        val buttonTextColors =
            if (type == "bluishType") AppTheme.colors.colorWhite else if (type == "greyishType") AppTheme.colors.colorWhite else AppTheme.colors.colorBrightBlue

        val borderColors =
            if (type == "bluishType") AppTheme.colors.colorBrightBlue else if (type == "greyishType") AppTheme.colors.colorButtonGray else AppTheme.colors.colorBrightBlue

        Button(
            modifier = modifier
                .bounceClickEffect()
                .fillMaxWidth()
                .height(AppTheme.dimens.dimens_50)
                .border(
                    width = 1.dp,
                    brush = Brush.horizontalGradient(
                        listOf(
                            borderColors,
                            borderColors
                        )
                    ),
                    shape = RoundedCornerShape(AppTheme.dimens.dimens_12)
                ),
            shape = RoundedCornerShape(20),
            colors = ButtonDefaults.textButtonColors(buttonColors),
            onClick = {
                hapticFeedback.performHapticFeedback(HapticFeedbackType.LongPress)
                onClick(isValid)
            }) {
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (type == "transparencyType") {
                    Icon(
                        modifier = Modifier.padding(end = AppTheme.dimens.dimens_12),
                        imageVector = Icons.Default.DateRange,
                        tint = buttonTextColors,
                        contentDescription = "uploadImage"
                    )
                }

                Text(
                    text = title,
                    textAlign = TextAlign.Center,
                    style = AppTheme.typography.h6.copy(buttonTextColors)
                )
            }
        }
    }

    @Composable
    fun WarpTextField(
        modifier: Modifier = Modifier,
        defaultValue: String,
        placeholderText: String,
        placeHolderColor: Color = AppTheme.colors.colorDeepBlue,
        buttonOffsetX: Dp,
        textLength: Int = Int.MAX_VALUE,
        keyboardOptions: KeyboardOptions,
        onValueChange: (String) -> Unit
    ) {
        val focusManager = LocalFocusManager.current

        TextField(
            value = defaultValue,
            onValueChange = onValueChange,
            modifier = modifier
                .fillMaxWidth()
                .offset(x = buttonOffsetX, y = 0.dp)
                .border(
                    width = 1.dp,
                    brush = Brush.horizontalGradient(
                        listOf(
                            AppTheme.colors.colorGray,
                            AppTheme.colors.colorGray
                        )
                    ),
                    shape = RoundedCornerShape(AppTheme.dimens.dimens_15)
                ),
            colors = TextFieldDefaults.textFieldColors(
                textColor = AppTheme.colors.colorBlack,
                backgroundColor = colorResource(
                    id = R.color.white
                ),
                cursorColor = AppTheme.colors.colorBrightBlue,
                disabledIndicatorColor = AppTheme.colors.colorShadowGrey,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            placeholder = {
                androidx.compose.material.Text(
                    placeholderText,
                    style = AppTheme.typography.contentBlockText.copy(placeHolderColor),
                    textAlign = TextAlign.Start,
                    modifier = Modifier.fillMaxWidth()
                )
            },
            maxLines = 1,
            shape = RoundedCornerShape(AppTheme.dimens.dimens_15),
            textStyle = AppTheme.typography.contentBlockText.copy(
                textAlign = TextAlign.Start,
                color = AppTheme.colors.colorBlack
            ),
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

    @Composable
    fun ImageItem(
        modifier: Modifier,
        data: Any?,
        crossfadeValue: Int = 300,
        contentDescription: String? = null,
        contentScale: ContentScale = ContentScale.Crop
    ) {
        coil.compose.AsyncImage(
            modifier = modifier,
            model = ImageRequest.Builder(LocalContext.current)
                .data(data)
                .crossfade(crossfadeValue)
                .build(),
            contentDescription = contentDescription,
            contentScale = contentScale
        )
    }
}

