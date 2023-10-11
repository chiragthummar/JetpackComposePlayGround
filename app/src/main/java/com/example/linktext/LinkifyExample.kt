package com.example.linktext

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp

@Composable
fun LinkifyExample() {
    Column(
        modifier = Modifier.fillMaxSize().statusBarsPadding()
            .padding(12.dp)
    ) {
        val tagTerms = "Terms of Use"
        val tagsPrivacyPolicy = "Privacy policy"
        val annotatedString = buildAnnotatedString {
            append("By clicking or entering app, You agree to the App's ")
            withStyle(style = SpanStyle(color = Color.Blue)) {
                //Tag will be use to identify which link or text clicked | Annotation is what to show the text for tag
                pushStringAnnotation(tag = tagTerms, annotation = tagTerms)
                append(tagTerms)
            }
            append(" and ")
            withStyle(style = SpanStyle(color = Color.Blue)) {
                pushStringAnnotation(tag = tagsPrivacyPolicy, annotation = tagsPrivacyPolicy)
                append(tagsPrivacyPolicy)
            }
        }
        Box(
            modifier = Modifier
                .padding(horizontal = 15.dp, vertical = 8.dp).fillMaxWidth()
                .clip(shape = RoundedCornerShape(50))
                .background(color = Color.Black).padding(vertical = 15.dp),
            contentAlignment = Alignment.Center
        ){
            Text(text = "Proceed to open", color = Color.White)
        }
        ClickableText(text = annotatedString, onClick = { offset ->
            annotatedString.getStringAnnotations(offset, offset)
                .firstOrNull()?.let { span ->
                    println("Clicked on ${span.item}") //Handle you TAG click
                }
        })
    }
}