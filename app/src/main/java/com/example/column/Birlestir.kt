package com.example.column

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposeplayground.R
import com.example.jetpackcomposeplayground.ui.theme.JetpackComposePlayGroundTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BizCard() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Sample App") }, colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Blue
                )
            )
        }
    ) {

        Column(modifier = Modifier.padding(it)) {
            TopCard()
            BottomCard()
        }
    }
}


@Composable
fun ColumnScope.TopCard() {
    Column(
        modifier = Modifier
            .weight(3f)
            .padding(8.dp)
            .border(width = 1.dp, color = Color.Blue),
        verticalArrangement = Arrangement.Bottom
    ) {
        Image(
            painter = painterResource(id = R.drawable.istockphoto_1413766112_612x612),
            contentDescription = "",
            modifier = Modifier
                .height(90.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.FillHeight
        )

        Text(
            "Full Name",
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            textAlign = TextAlign.Center
        )

        Text(
            "Title Role",
            fontSize = 16.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            textAlign = TextAlign.Center
        )

    }
}


@Composable
fun ColumnScope.BottomCard() {
    Column(
        modifier = Modifier
            .weight(2f)
            .padding(8.dp)
            .border(width = 1.dp, color = Color.Blue),
        verticalArrangement = Arrangement.Bottom
    ) {
        BottomItem()
        BottomItem()
        BottomItem()
        BottomItem()
    }
}

@Composable
fun BottomItem() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.istockphoto_1413766112_612x612),
            contentDescription = "",
            modifier = Modifier
                .size(22.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.FillHeight
        )
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            "+4 00 00 00 00",
            fontSize = 15.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposePlayGroundTheme {
        BizCard()
    }
}