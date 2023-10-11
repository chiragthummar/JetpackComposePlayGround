package com.example.jetpackcomposeplayground

import android.content.ContentValues.TAG
import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.FrameLayout
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.animation.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material3.DrawerValue
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidViewBinding
import androidx.core.os.LocaleListCompat
import androidx.core.os.bundleOf
import androidx.core.view.WindowCompat
import com.example.actionbaredit.ActionBarEdit
import com.example.expandabletext.ExpandableTextExample
import com.example.jetpackcomposeplayground.databinding.BannerRootBinding
import com.example.jetpackcomposeplayground.databinding.LayoutNativeAdMediumBinding
import com.example.jetpackcomposeplayground.ui.theme.JetpackComposePlayGroundTheme
import com.example.linktext.LinkifyExample
import com.example.recomposition.RecompositionExample
import com.facebook.shimmer.ShimmerFrameLayout
import com.google.ads.mediation.admob.AdMobAdapter
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.RequestConfiguration
import com.google.android.gms.ads.nativead.NativeAdOptions
import com.google.android.gms.ads.nativead.NativeAdOptions.ADCHOICES_TOP_LEFT

class MainActivity : AppCompatActivity() {


    private val viewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge(
        )
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContent {
            JetpackComposePlayGroundTheme {
                ActionBarEdit()
            }

        }

        // Turn off the decor fitting system windows, which allows us to handle insets,
        // including IME animations
        //WindowCompat.setDecorFitsSystemWindows(window, false)

        /* val list1 = listOf(
             MyFile(
                 "A",
                 "AB",
                 true,
                 false,
                 false,
                 100
             ),
             MyFile(
                 "B",
                 "AHB",
                 true,
                 false,
                 false,
                 100
             ),
             MyFile(
                 "C",
                 "ABD",
                 true,
                 false,
                 false,
                 100
             ), MyFile(
                 "D",
                 "ADB",
                 true,
                 true,
                 false,
                 100
             )

         )

         val list2 = listOf(
             MyFile(
                 "A",
                 "AB",
                 true,
                 false,
                 false,
                 100
             ),
             MyFile(
                 "B",
                 "AHB",
                 true,
                 false,
                 false,
                 100
             ), MyFile(
                 "D",
                 "ADB",
                 true,
                 false,
                 false,
                 100
             )

         )*/
//        ComposeView(this).apply {
//            consumeWindowInsets = false
//            setContent {
//                JetpackComposePlayGroundTheme {
//
//
//                    val drawerState =
//                        androidx.compose.material3.rememberDrawerState(initialValue = DrawerValue.Closed)
//                    val drawerOpen by viewModel.drawerShouldBeOpened
//                        .collectAsState()
//                    // Intercepts back navigation when the drawer is open
//                    val scope = rememberCoroutineScope()
//                    if (drawerState.isOpen) {
//                        BackHandler {
//                            scope.launch {
//                                drawerState.close()
//                            }
//                        }
//                    }
//                    if (drawerOpen) {
//                        // Open drawer and reset state in VM.
//                        LaunchedEffect(Unit) {
//                            // wrap in try-finally to handle interruption whiles opening drawer
//                            try {
//                                drawerState.open()
//                            } finally {
//                                viewModel.resetOpenDrawerAction()
//                            }
//                        }
//                    }
//
//                    JetchatDrawer(
//                        drawerState = drawerState,
//                        onChatClicked = {
//
//                            scope.launch {
//                                drawerState.close()
//                            }
//                        },
//                        onProfileClicked = {
//                            val bundle = bundleOf("userId" to it)
//
//                            scope.launch {
//                                drawerState.close()
//                            }
//                        }
//                    ) {
//
//                        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
//                            Text(
//                                text = "jdfklsjdflsdjlfkjsldkjflsjfljsldfkjsldfjlksjflsdjflkjslkfjlksjfkljdsfjdfklsjdflsdjlfkjsldkjflsjfljsldfkjsldfjlksjflsdjflkjslkfjlksjfkljdsfjdfklsjdflsdjlfkjsldkjflsjfljsldfkjsldfjlksjflsdjflkjslkfjlksjfkljdsf",
//                                modifier = Modifier.clickable {
//                                    scope.launch {
//                                        drawerState.open()
//                                    }
//                                })
//                        }
//
//                    }
//
//
////                PlayScreen()
//                    //OrderChequeRequestScreen()
//                    /*val diff = list1.filter { item -> !list2.contains(item) }.toList()
//                val newList = list1.minus(diff)
//                Log.e(TAG, "onCreate: ${diff}")
//                Log.e(TAG, "onCreate: newList ${newList}")
//
//                val e1 = MyFile(
//                    "D",
//                    "ADB",
//                    true,
//                    true,
//                    false,
//                    100
//                )
//                val e2 = MyFile(
//                    "D",
//                    "ADB",
//                    true,
//                    false,
//                    false,
//                    100
//                )
//
//                Log.e(TAG, "onCreate: Are Same ${e1 == e2}")*/
//
//
//                }
//            }
//        }
    }
}


fun listTips() {
    val items = listOf("1", "1", "2", "2", "2", "3", "3", "3", "4")

    val uniqueItems = items.toSet()

    println(uniqueItems)
}

@Composable
fun CollapsibleBanner(

) {


    var adUnit: String = "ca-app-pub-8785923025546886/4995272155"
//        var adUnit: String = "ca-app-pub-3940256099942544/6300978111"
    if (adUnit.isEmpty()) {
        adUnit = "ca-app-pub-6530974883137971/7160886988"
    }
    val str = adUnit

    val context = LocalContext.current

    AndroidViewBinding(
        factory = BannerRootBinding::inflate, modifier = Modifier.navigationBarsPadding()
    ) {


        val frameLayout = this.adFrameLayout.bannerContainer
        val shimmerFrameLayout = this.adFrameLayout.shimmerContainerBanner

        shimmerFrameLayout.visibility = View.VISIBLE
        shimmerFrameLayout.startShimmer()
        val adView = AdView(context)
        adView.adUnitId = str
        frameLayout.addView(adView)


//        val defaultDisplay = context.windowManager.defaultDisplay
        val displayMetrics = context.resources.displayMetrics;
//        defaultDisplay.getMetrics(displayMetrics)


        Log.e(TAG, "CollapsibleBanner: Height ${displayMetrics.widthPixels}")
        Log.e(TAG, "CollapsibleBanner: Density ${displayMetrics.density}")

        val currentOrientationAnchoredAdaptiveBannerAdSize =
            AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(
                context, (displayMetrics.widthPixels / displayMetrics.density).toInt()
            )
        shimmerFrameLayout.layoutParams.height =
            (currentOrientationAnchoredAdaptiveBannerAdSize.height * Resources.getSystem().displayMetrics.density + 0.5f).toInt()
        adView.setAdSize(currentOrientationAnchoredAdaptiveBannerAdSize)
        adView.setLayerType(View.LAYER_TYPE_SOFTWARE, null)
        val bundle = Bundle()
        bundle.putString("collapsible", "bottom")
        adView.loadAd(
            AdRequest.Builder().addNetworkExtrasBundle(AdMobAdapter::class.java, bundle).build()
        )
        adView.adListener = aux(shimmerFrameLayout, frameLayout, adView, str)

    }

}


@Composable
fun NativeMediumAd(

) {

    var isAdRequested = false

    AndroidViewBinding(
        factory = LayoutNativeAdMediumBinding::inflate, modifier = Modifier.navigationBarsPadding()
    ) {

        if (isAdRequested) return@AndroidViewBinding
        val adView = nativeAdView.also { adView ->
            adView.adChoicesView = adChoice
            adView.bodyView = tvBody
            adView.callToActionView = btnCta
            adView.headlineView = tvHeadline
            adView.iconView = ivAppIcon
            adView.mediaView = mvContent
        }

        kotlin.runCatching {
            AdLoader.Builder(adView.context, "ca-app-pub-3940256099942544/2247696110")
                .forNativeAd { nativeAd ->
                    nativeAd.body?.let { body ->
                        tvBody.text = body
                    }

                    nativeAd.callToAction?.let { cta ->
                        btnCta.text = cta
                    }

                    nativeAd.headline?.let { headline ->
                        tvHeadline.text = headline
                    }

                    nativeAd.icon?.let { icon ->
                        ivAppIcon.setImageDrawable(icon.drawable)
                    }

                    adView.setNativeAd(nativeAd)
                }.withAdListener(object : AdListener() {
                    override fun onAdLoaded() {
                        super.onAdLoaded()
                        imageContainer.visibility = View.GONE
                        adView.visibility = View.VISIBLE
                    }
                }).withNativeAdOptions(
                    NativeAdOptions.Builder().setAdChoicesPlacement(ADCHOICES_TOP_LEFT).build()
                ).build()
        }.onSuccess {
            it.loadAd(AdRequest.Builder().build())
        }
    }
}

private val countryList = mutableListOf("India", "Pakistan", "China", "Nepal", "Sri Lanka", "Berma")

private val listModifier = Modifier
    .fillMaxSize()
    .background(Color.Gray)
    .padding(10.dp)


private val textStyle = TextStyle(fontSize = 20.sp, color = Color.White)

@Composable
private fun AnimatableSample() {
    var isAnimated by remember { mutableStateOf(false) }

    val color = remember { Animatable(Color.DarkGray) }

    // animate to green/red based on `button click`
    LaunchedEffect(isAnimated) {
        color.animateTo(if (isAnimated) Color.Green else Color.Red, animationSpec = tween(2000))
    }

    Box(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.8f)
            .background(color.value)
    )
    Button(
        onClick = { isAnimated = !isAnimated }, modifier = Modifier.padding(top = 10.dp)
    ) {
        Text(text = "Animate Color")
    }
}
