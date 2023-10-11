package com.example.jetpackcomposeplayground

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp

@Composable
fun Ex9() {

    var rawText by remember { mutableStateOf(TextFieldValue()) }

    // Derived state for styled input
    val styledText: TextFieldValue by remember(rawText) {
        derivedStateOf {
            Log.d("testing", "derived state")
            val annotatedString = buildAnnotatedString {
                withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
                    append(rawText.text)
                }
            }
            TextFieldValue(annotatedString, rawText.selection, rawText.composition)
        }
    }
}

@Composable
fun StyledTextFieldWithToggleBoldButton() {
    val rawText = remember { mutableStateOf(TextFieldValue()) }

    var count by remember { mutableStateOf(0) }

    Column {
        BasicTextField(
            value = rawText.value.copy(annotatedString = buildAnnotatedString {
                withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
                    append(rawText.value.text)
                }
            }),
            onValueChange = { value ->
                Log.d("testing", "on value change")
                    rawText.value = value
            },
            textStyle = TextStyle(color = Color.Black),
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(16.dp),
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            count = 0
        }) {
            Text("Toggle Bold")
        }
    }
}