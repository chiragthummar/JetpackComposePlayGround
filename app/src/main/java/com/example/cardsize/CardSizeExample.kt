package com.example.cardsize

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposeplayground.R
import com.example.jetpackcomposeplayground.ui.theme.JetpackComposePlayGroundTheme

@Preview
@Composable
fun Pre() {
    JetpackComposePlayGroundTheme {
        CardSizeExample()
    }
}


@Composable
fun CardSizeExample() {
    Card() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Row(
                modifier = Modifier.height(IntrinsicSize.Max)
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = R.drawable.istockphoto_1413766112_612x612),
                            contentScale = ContentScale.Crop,
                            contentDescription = "",
                            modifier = Modifier
                                .clip(CircleShape)
                                .size(48.dp)
                        )
                        Column(
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .heightIn(min = 48.dp)
                                .padding(start = 8.dp)
                        ) {
                            Text("User name") // user display name
                            Spacer(modifier = Modifier.height(4.dp))
                            Text("Time Stamp") // timestamp
                        }
                    }

                    Text(
                        text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                        minLines = 3,
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.padding(top = 12.dp)
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.istockphoto_1413766112_612x612),
                    contentScale = ContentScale.FillHeight,
                    contentDescription = "",
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .weight(1f, false)
                        .fillMaxHeight()
                )
            }
        }
    }
}