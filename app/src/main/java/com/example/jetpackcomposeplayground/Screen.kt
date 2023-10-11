package com.example.jetpackcomposeplayground

sealed class NavRoute(val route: String) {
    object Home : NavRoute("home")
    object Settings : NavRoute("settings")
    object Screen1 : NavRoute("sc1")
    object Screen2 : NavRoute("sc2")
    object Screen3 : NavRoute("sc3")
}
