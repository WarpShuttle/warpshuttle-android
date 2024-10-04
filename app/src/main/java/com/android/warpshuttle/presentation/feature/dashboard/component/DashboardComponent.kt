package com.android.warpshuttle.presentation.feature.dashboard.component

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.android.warpshuttle.R
import com.android.warpshuttle.presentation.ui.component.ComponentClass
import com.android.warpshuttle.presentation.ui.theme.AppTheme

object DashboardComponent {
    @Composable
    fun AddOrEditBlogPopupDialog(
        onDismiss: () -> Unit,
        onSend: (Uri?, String) -> Unit
    ) {
        var description by remember { mutableStateOf("") }
        var imageUri by remember { mutableStateOf<Uri?>(null) }

        // Image picker launcher
        val context = LocalContext.current
        val launcher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.GetContent()
        ) { uri: Uri? ->
            imageUri = uri
        }

        AlertDialog(
            containerColor = AppTheme.colors.colorWhite,
            modifier = Modifier
                .padding(horizontal = AppTheme.dimens.dimens_20)
                .clip(RoundedCornerShape(AppTheme.dimens.dimens_12)),
            onDismissRequest = { onDismiss() },
            title = {
                Text(
                    text = "Write new blog",
                    textAlign = TextAlign.Center,
                    style = AppTheme.typography.contentBlockSubHeader.copy(color = AppTheme.colors.colorBlack),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = AppTheme.dimens.dimens_12)
                )
            },
            text = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    ComponentClass.WarpTextField(
                        modifier = Modifier.padding(bottom = AppTheme.dimens.dimens_12),
                        defaultValue = description,
                        placeholderText = "Enter Title",
                        placeHolderColor = AppTheme.colors.colorGray,
                        buttonOffsetX = 0.dp,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password,
                        ),
                        onValueChange = { description = it }
                    )

                    ComponentClass.WarpTextField(
                        modifier = Modifier.padding(bottom = AppTheme.dimens.dimens_12),
                        defaultValue = description,
                        placeholderText = "Enter Description",
                        placeHolderColor = AppTheme.colors.colorGray,
                        buttonOffsetX = 0.dp,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password,
                        ),
                        onValueChange = { description = it }
                    )

                    TextButton(modifier = Modifier
                        .fillMaxWidth()
                        .offset(x = 0.dp, y = 0.dp)
                        .border(
                            width = 1.dp,
                            brush = Brush.horizontalGradient(
                                listOf(
                                    AppTheme.colors.colorGray,
                                    AppTheme.colors.colorGray
                                )
                            ),
                            shape = RoundedCornerShape(AppTheme.dimens.dimens_15)
                        ), onClick = { /*TODO*/ }) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceAround,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.Share,
                                tint = AppTheme.colors.colorGray,
                                contentDescription = "uploadImage"
                            )
                            Spacer(modifier = Modifier.size(AppTheme.dimens.dimens_12))
                            Text(
                                text = "Image12.jpeg",
                                textAlign = TextAlign.Center,
                                style = AppTheme.typography.h6.copy(color = AppTheme.colors.colorGray),
                            )
                        }
                    }

                    // Image Upload
//                    Box(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .clickable {
//                                // Open image picker
//                                launcher.launch("image/*")
//                            },
//                        contentAlignment = Alignment.Center
//                    ) {
//                        if (imageUri != null) {
//                            Image(
//                                painter = painterResource(id = R.drawable.ic_dummy_banner),
//                                contentDescription = null,
//                                modifier = Modifier.fillMaxSize(),
//                                contentScale = ContentScale.Crop
//                            )
//                        } else {
//                            Text(text = "Click to upload image")
//                        }
//                    }
                }
            },
            confirmButton = {
//                Button(onClick = {
//                    onSend(imageUri, description)
//                    onDismiss()
//                }) {
//                    Text("Send")
//                }
                ComponentClass.WarpButton(
                    modifier = Modifier.padding(
                        bottom = AppTheme.dimens.dimens_12
                    ), title = "Submit", type = "bluishType",isValid = true
                ) {
                    onSend(imageUri, description)
                    onDismiss()
                }
            },
        )
    }

    @Composable
    fun ProfileView(modifier : Modifier, data:Any?) {
        Column {
            ComponentClass.ImageItem(
                modifier = modifier
                    .fillMaxSize()
                    .weight(0.35f),
                data = data,
                contentScale = ContentScale.Crop
            )

            Column( modifier = Modifier
                .fillMaxSize()
                .weight(0.65f)) {

                Text(text = "ANDROID DEVELOPER")
                Text(text = "Ronit Prajapati")

            }
        }
    }
}