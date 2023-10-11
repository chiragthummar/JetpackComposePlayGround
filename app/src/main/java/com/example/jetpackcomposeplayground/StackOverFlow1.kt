package com.example.jetpackcomposeplayground

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@Composable
fun PlayScreen() {
    // Create a ViewModel to handle the logic and data for the Composable
    val viewModel: PractiseViewModel = viewModel()
    val imageInfoList = viewModel.imageInfoList.value

    LazyColumn() {
        items(imageInfoList.size) { index ->
            Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.padding(8.dp)) {
//                ImageInfoCard(imageInfoData = imageInfoList[index])
                Image(
                    painter = painterResource(id = imageInfoList[index].imageResId),
                    contentDescription = imageInfoList[index].name,
                    modifier = Modifier
                        .background(Color.Green)
                        .width(180.dp)
                        .height(100.dp),
                    contentScale = ContentScale.Inside
                )
                Text(
                    text = imageInfoList[index].name,
                    modifier = Modifier
                        .background(Color.Red)
                        .fillMaxWidth()
                        .height(100.dp),
                    style = TextStyle(fontSize = 16.sp),
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}

fun generateImageList(): List<ImageInfoData> {
    val images = listOf(
        R.drawable.apple,
        R.drawable.mango,
        R.drawable.banana,
        R.drawable.grapes,
        R.drawable.strawberry
    )

    val imageNames = listOf("Apple", "Mango", "Banana", "Coconut", "Orange")
    val shuffledNames = imageNames.shuffled()

    return images.zip(shuffledNames) { image, name ->
        ImageInfoData(image, name)
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ImageInfoCard(imageInfoData: ImageInfoData) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        onClick = {
            // Handle click event here
        }
    ) {
        Column {
            Image(
                painter = painterResource(id = imageInfoData.imageResId),
                contentDescription = imageInfoData.name,
                modifier = Modifier
                    .background(Color.Green)
                    .width(180.dp)
                    .height(100.dp),
                contentScale = ContentScale.Inside
            )
        }
    }
}

@Preview
@Composable
fun PlayScreenPreview() {
    PlayScreen()
}

class PractiseViewModel : ViewModel() {

    //MutableStateFlow to hold the list of ImageInfoData

    private val _imageInfoList = MutableStateFlow<List<ImageInfoData>>(emptyList())
    val imageInfoList: StateFlow<List<ImageInfoData>> get() = _imageInfoList

    init {
        viewModelScope.launch {
            _imageInfoList.value = generateImageList()
        }
    }
}

data class ImageInfoData(val imageResId: Int, val name: String)
