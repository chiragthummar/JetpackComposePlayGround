package com.example.jetpackcomposeplayground

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposeplayground.ui.theme.JetpackComposePlayGroundTheme

@Preview(showBackground = true)
@Composable
fun Ex19Preview() {
    JetpackComposePlayGroundTheme {
        Ex19()
    }
}


@Composable
fun Ex19() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = {
//            navigateUp()
            }) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "Back",
            )
        }
        Text(text = "Custom title", modifier = Modifier
            .fillMaxWidth()
            .weight(1f))
    }
}

/*

@Composable
fun Ex18() {
    var selectedTabIndex by remember { mutableIntStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black),

            ) {
            TabRow(
                selectedTabIndex = selectedTabIndex,
                modifier = Modifier.background(Color.White),
                containerColor = Color.White,
                indicator = { tabPositions ->
                    TabRowDefaults.Indicator(
                        color = Color(3, 169, 244),
                        modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex])
                    )
                },
                tabs = {}
            )
        }
    }
}*/
