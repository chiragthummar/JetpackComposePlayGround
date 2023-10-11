package com.example.jetpackcomposeplayground

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposeplayground.ui.theme.JetpackComposePlayGroundTheme


@Preview
@Composable
fun PD() {
    JetpackComposePlayGroundTheme {
        Demo()
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Demo() {
    val searchTextFieldValue = remember { mutableStateOf(TextFieldValue()) }

    Box(
        modifier = Modifier
            .padding(horizontal = 10.dp, vertical = 0.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(shape = RoundedCornerShape(24.dp))
            .background(color = Color.Gray)
            .padding(horizontal = 10.dp)
    ) {
        BasicTextField(
            value = searchTextFieldValue.value,
            onValueChange = { newText ->
                searchTextFieldValue.value = newText
            },
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.None,
                autoCorrect = false,
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(onDone = {

            }),
            textStyle = TextStyle(
                fontSize = 13.sp,
                fontWeight = FontWeight.Medium,
            ),

            maxLines = 1,
            minLines = 1,
            decorationBox = { innerTextField ->
                TextFieldDefaults.TextFieldDecorationBox(colors = TextFieldDefaults.textFieldColors(
                    cursorColor = Color.White,
                    focusedIndicatorColor = Color.White,
                ), value = searchTextFieldValue.value.text,
                    visualTransformation = VisualTransformation.None,
                    innerTextField = {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(6.dp)
                        ) {
                            innerTextField()
                        }
                    },
                    placeholder = {
                        Text(
                            text = "Search",
                            modifier = Modifier
                                .padding(5.dp)
                                .fillMaxWidth(),
                            style = TextStyle(
                                fontSize = 14.sp,
                            )
                        )
                    },
                    singleLine = true,
                    enabled = true,
                    contentPadding = PaddingValues(4.dp),
                    interactionSource = remember { MutableInteractionSource() })
            },

            )

    }
}