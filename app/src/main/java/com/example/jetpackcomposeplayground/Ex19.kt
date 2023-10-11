package com.example.jetpackcomposeplayground

import android.annotation.SuppressLint
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import kotlinx.coroutines.delay
/*

@SuppressLint("SuspiciousIndentation")
@ExperimentalPagerApi
@Composable
fun ViewPagerSlider() {
    var autoScroll = remember { mutableStateOf(0) }

    val pagerState = rememberPagerState(
        pageCount = CatalogList.size,
        initialPage = 0,
        infiniteLoop = true
    )

    LaunchedEffect(Unit) {
        while(++autoScroll.value <= 3) {
            yield()
            delay(2000)
            pagerState.animateScrollToPage(
                page = (pagerState.currentPage + 1),
                animationSpec = tween(600)
            )
        }
    }


    Box() {
        VerticalPager(
            state = pagerState,
            dragEnabled = userScroll.value,
            modifier = Modifier
                .fillMaxSize()
        ) { indexPage ->
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
            ) {
                //////// CONTENT /////////
            }
        }

        IconButton(
            modifier = Modifier
                .onClick = {
                autoScroll.value = 5
            }
        ) {
            Icon(
                imageVector = Icons.Filled.Info,
                contentDescription = "Info",
                tint = Color.Red,
            )
        }
    }
}*/
