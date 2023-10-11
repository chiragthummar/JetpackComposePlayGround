package com.example.jetpackcomposeplayground

import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.withStyle


@Composable
fun StyleEditTextWithoutInfiniteRecomposition() {
    val testText = remember { mutableStateOf(TextFieldValue()) }
    TextField(
        value = testText.value,
        onValueChange = {
            testText.value = it
        },
        visualTransformation = {
            TransformedText(
                text = buildAnnotatedString {
                    withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
                        append(testText.value.text)
                    }
                },
                offsetMapping = OffsetMapping.Identity
            )
        }
    )
}
