package com.example.jetpackcomposeplayground

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
//
//
//@Composable
//fun MainScreen() {
//    val navController: NavHostController = rememberNavController()
//    SetupNavGraph(navController = navController)
//
//}
//
//@Composable
//fun SetupNavGraph(navController: NavHostController) {
//    NavHost(
//        navController = navController,
//        startDestination = Screen.Search.route
//    ) {
//        composable(route = Screen.Search.route) {
//            HomeScreen {
//                navController.navigate(it)
//            }
//        }
//        composable(route = Screen.Setting.route) {
//            Pengaturan(navController = navController)
//        }
//    }
//}
//
//@Composable
//fun HomeScreen(navigateTo: (route: String) -> Unit) {
//    Column {
//        Search(navigateTo = navigateTo)
//        Box(
//            modifier = Modifier
//                .fillMaxSize()
//                .weight(1f), contentAlignment = Alignment.Center
//        )
//        {
//            Text(
//                text = "Ini Halaman Utama",
//                color = Color.Blue,
//                textAlign = TextAlign.Center
//            )
//        }
//    }
//}
//
//sealed class Screen(val route: String) {
//    object Search : Screen(route = "Screen_Home")
//    object Setting : Screen(route = "Screen_Setting")
//}
//
//@Composable
//fun Search(navigateTo: (route: String) -> Unit) {
//    Box(
//
//    ) {
//        Icon(imageVector = Icons.Default.Settings,
//            contentDescription = "Masuk Ke Menu Settings",
//            tint = Color.Black,
//            modifier = Modifier.clickable {
//                navigateTo(Screen.Setting.route)
//            })
//    }
//}
//
//@Composable
//fun Pengaturan(navController: NavHostController) {
//    Box(
//        modifier = Modifier.fillMaxSize(),
//        contentAlignment = Alignment.Center
//    )
//    {
//        Text(text = "Ini Adalah Halaman Pengaturan", color = Color.Red)
//    }
//    Icon(imageVector = Icons.Default.ArrowBack,
//        contentDescription = "Kembali Ke Halaman Utama",
//        tint = Color.Red,
//        modifier = Modifier
//            .clickable { navController.navigate(route = Screen.Search.route) })
//}
//
