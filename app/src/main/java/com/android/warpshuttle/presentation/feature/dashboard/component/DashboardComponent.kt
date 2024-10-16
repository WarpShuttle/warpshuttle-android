package com.android.warpshuttle.presentation.feature.dashboard.component

import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import com.android.warpshuttle.data.enums.ViewType
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
                    ), title = "Submit", type = "bluishType", isValid = true
                ) {
                    onSend(imageUri, description)
                    onDismiss()
                }
            },
        )
    }

    @Composable
    fun ProfileView(modifier: Modifier, data: Any?, viewType: String?) {
        Column {
            ComponentClass.ImageItem(
                modifier = modifier
                    .fillMaxSize()
                    .weight(if (viewType.equals(ViewType.TEAMVIEW.type)) 0.65f else 0.35f),
                data = data,
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(if (viewType.equals(ViewType.TEAMVIEW.type)) 0.35f else 0.65f),
            ) {
                Text(
                    text = "ANDROID DEVELOPER",
                    textAlign = TextAlign.Center,
                    style = AppTheme.typography.body1.copy(color = AppTheme.colors.colorGray),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = AppTheme.dimens.dimens_20)
                )

                Text(
                    text = "Ronit Prajapati",
                    textAlign = TextAlign.Center,
                    style = AppTheme.typography.contentBlockSubHeader.copy(color = AppTheme.colors.colorBlack),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = AppTheme.dimens.dimens_12)
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = AppTheme.dimens.dimens_12),
                    horizontalArrangement = Arrangement.Center
                ) {
                    IconButton(
                        onClick = {},
                        modifier = Modifier
                            .padding(6.dp)
                            .background(AppTheme.colors.colorLightGray, CircleShape)
                    ) {
                        Icon(
                            imageVector = Icons.Default.AccountBox,
                            tint = AppTheme.colors.colorBrightBlue,
                            contentDescription = "uploadImage",
                            modifier = Modifier
                        )
                    }
                    IconButton(
                        onClick = {},
                        modifier = Modifier
                            .padding(6.dp)
                            .background(AppTheme.colors.colorLightGray, CircleShape)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Call,
                            tint = AppTheme.colors.colorBrightBlue,
                            contentDescription = "uploadImage",
                            modifier = Modifier
                        )
                    }
                    IconButton(
                        onClick = {},
                        modifier = Modifier
                            .padding(6.dp)
                            .background(AppTheme.colors.colorLightGray, CircleShape)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Email,
                            tint = AppTheme.colors.colorBrightBlue,
                            contentDescription = "uploadImage",
                            modifier = Modifier
                        )
                    }
                    IconButton(
                        onClick = {},
                        modifier = Modifier
                            .padding(6.dp)
                            .background(AppTheme.colors.colorLightGray, CircleShape)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Share,
                            tint = AppTheme.colors.colorBrightBlue,
                            contentDescription = "uploadImage",
                            modifier = Modifier
                        )
                    }
                }

                if (viewType == ViewType.PROFILEVIEW.type) {
                    Column(
                        modifier = Modifier.padding(
                            horizontal = AppTheme.dimens.dimens_12,
                            vertical = AppTheme.dimens.dimens_12
                        )
                    ) {
                        ComponentClass.WarpButton(
                            title = "Edit Profile",
                            isValid = true,
                            type = "bluishType",
                            modifier = Modifier.padding(vertical = AppTheme.dimens.dimens_12)
                        ) {

                        }

                        ComponentClass.WarpButton(
                            title = "Change Password",
                            isValid = true,
                            type = "",
                            modifier = Modifier.padding(vertical = AppTheme.dimens.dimens_12)
                        ) {

                        }
                    }
                }
            }
        }
    }
}