package com.example.jetpackcomposeplayground

import android.os.Build
import android.os.Build.VERSION.SDK_INT
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import coil.size.Scale
import coil.size.Size

@Composable
fun GIFDemo(
    modifier: Modifier = Modifier,
) {
//    val context = LocalContext.current
//    val imageLoader = ImageLoader.Builder(context)
//        .components {
//            if (SDK_INT >= 28) {
//                add(ImageDecoderDecoder.Factory())
//            } else {
//                add(GifDecoder.Factory())
//            }
//        }
//        .build()
//    Image(
//        painter = rememberAsyncImagePainter(
//            ImageRequest.Builder(context).data(data = R.drawable.YOUR_GIF).apply(block = {
//                size(Size.ORIGINAL)
//            }).build(), imageLoader = imageLoader
//        ),
//        contentDescription = null,
//        modifier = modifier.fillMaxWidth(),
//    )
    LoadingImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(data = R.drawable.my)
            .apply(block = { size(Size.ORIGINAL) })
            .crossfade(true)
            .scale(Scale.FILL)
            .build(),
        contentDescription = "Character Picture",
        modifier = Modifier
            .aspectRatio(1.1f)
            .padding(8.dp)
    )
}


@Composable
fun LoadingImage(
    model: Any,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Fit,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null,
    loader: @Composable () -> Unit = { CircularProgressIndicator() }
) {

    val imageLoader = ImageLoader
        .Builder(LocalContext.current)
        .components {
            if (Build.VERSION.SDK_INT >= 28) {
                add(ImageDecoderDecoder.Factory())
            } else {
                add(GifDecoder.Factory())
            }
        }
        .build()

    val painter = rememberAsyncImagePainter(
        model = model,
        imageLoader = imageLoader
    )

    if (painter.state is AsyncImagePainter.State.Loading) {
        loader()
    }

    Image(
        modifier = modifier,
        painter = painter,
        contentScale = contentScale,
        contentDescription = contentDescription,
        alignment = alignment,
        alpha = alpha,
        colorFilter = colorFilter
    )
}


