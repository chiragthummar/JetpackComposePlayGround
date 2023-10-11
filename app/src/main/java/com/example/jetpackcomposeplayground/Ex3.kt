package com.example.jetpackcomposeplayground

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.window.Dialog
import androidx.core.view.doOnLayout
import com.example.jetpackcomposeplayground.ui.theme.JetpackComposePlayGroundTheme
import com.google.ads.mediation.admob.AdMobAdapter
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView

@Composable
fun FileInfoDialog(
    setShowDialog: (Boolean) -> Unit,
    setValue: (String) -> Unit,
    onClose: () -> Unit
) {

    Dialog(onDismissRequest = { setShowDialog(false) }) {
        Surface(
            shape = RoundedCornerShape(10.dp), color = Color.White
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Info",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    color = Color.Black,
                )
                Spacer(modifier = Modifier.weight(1f))

                Box(
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(8.dp))
                        .fillMaxWidth()
                        .height(42.dp)
                        .background(color = Color.Red)
                        .clickable {
                            onClose()
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Close", color = Color.White)
                }

            }

        }
    }
}


@Composable
fun Sample() {
    val showDialog = remember { mutableStateOf(false) }
    if (showDialog.value) {

        FileInfoDialog(
            setShowDialog = {
                showDialog.value = it
            },
            setValue = {},
        ) {
            showDialog.value = false
        }
    }



    Column {
        Box(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(8.dp))
                .fillMaxWidth()
                .height(42.dp)
                .background(color = Color.Gray)
                .clickable {
                    showDialog.value = true
                },
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Open Dialog", color = Color.Black)
        }
    }
}


@Composable
fun ScreenSizeHelper() {

    val context = LocalContext.current

    val displayMetrics = context.resources.displayMetrics

    //Width And Height Of Screen
    val width = displayMetrics.widthPixels
    val height = displayMetrics.heightPixels

    //Device Density
    val density = displayMetrics.density

}


//@Composable
//fun ExoplayerExample() {
//
//    val context = LocalContext.current
//
//    val mediaItem = MediaItem.Builder()
//        .setUri("your-uri")
//        .build()
//    val exoPlayer = remember(context, mediaItem) {
//        ExoPlayer.Builder(context)
//            .build()
//            .also { exoPlayer ->
//                exoPlayer.setMediaItem(mediaItem)
//                exoPlayer.prepare()
//                exoPlayer.playWhenReady = false
//                exoPlayer.repeatMode = REPEAT_MODE_OFF
//            }
//    }
//
//    DisposableEffect(
//        AndroidView(factory = {
//            StyledPlayerView(context).apply {
//                player = exoPlayer
//            }
//        })
//    ) {
//        onDispose { exoPlayer.release() }
//    }
//
//
//}
