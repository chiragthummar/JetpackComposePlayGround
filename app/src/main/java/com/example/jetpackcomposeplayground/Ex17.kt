package com.example.jetpackcomposeplayground

import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposeplayground.ui.theme.JetpackComposePlayGroundTheme

@Preview(showBackground = true)
@Composable
fun Ex17Preview() {
    JetpackComposePlayGroundTheme {
        Ex17()
    }
}


@Composable
fun Ex17() {
    // We have two radio buttons and only one can be selected
    var state by remember { mutableStateOf(true) }
    // Note that Modifier.selectableGroup() is essential to ensure correct accessibility behavior.
    // We also set a content description for this sample, but note that a RadioButton would usually
    // be part of a higher level component, such as a raw with text, and that component would need
    // to provide an appropriate content description. See RadioGroupSample.
    Row(
        Modifier
            .wrapContentHeight()
            .selectableGroup(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Row(Modifier.weight(1f).height(IntrinsicSize.Max)) {
            RadioButton(
                selected = state,
                onClick = { state = true },
                modifier = Modifier.semantics { contentDescription = "Localized Description" }
            )
            Text(text = "Option 1")
        }
        Row(Modifier.weight(1f)) {
            RadioButton(
                selected = !state,
                onClick = { state = false },
                modifier = Modifier.semantics { contentDescription = "Localized Description" }
            )
            Text(text = "Option 2")
        }
    }
}
