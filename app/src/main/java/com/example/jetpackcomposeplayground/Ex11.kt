package com.example.jetpackcomposeplayground

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun Ex11(
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavRoute.Home.route,
        modifier = Modifier.fillMaxSize()
    ) {
        composable(route = NavRoute.Home.route) {
            HomeScreen() {
                navController.navigate(it)
            }
        }
        composable(route = NavRoute.Settings.route) {
            SettingsScreen()
        }
    }
}

@Composable
fun SettingsScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Settings Screen", fontSize = 20.sp)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navigateTo: (route: String) -> Unit
) {

    val topLevelDestinations = listOf(
        TopLevelDestination(
            route = NavRoute.Screen1.route,
            selectedIcon = R.drawable.home,
            unselectedIcon = R.drawable.home_outline,
            iconText = "One"
        ), TopLevelDestination(
            route = NavRoute.Screen2.route,
            selectedIcon = R.drawable.bulb,
            unselectedIcon = R.drawable.bulb_outline,
            iconText = "Generate"
        ), TopLevelDestination(
            route = NavRoute.Screen3.route,
            selectedIcon = R.drawable.my_files,
            unselectedIcon = R.drawable.my_files_outline,
            iconText = "My Files"
        )
    )

    val showBottomBar = remember { mutableStateOf(true) }
    val title = remember {
        mutableStateOf("Home")
    }
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = {
                Text(
                    text = title.value,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                )
            }, colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary
            ), actions = {
                Icon(
                    imageVector = Icons.Filled.Settings,
                    tint = MaterialTheme.colorScheme.onPrimary,
                    contentDescription = "Settings",
                    modifier = Modifier
                        .clickable {
                            navigateTo(NavRoute.Settings.route)
                        }
                        .padding(8.dp)
                )
            })
        },
        bottomBar = {
            if (showBottomBar.value) {
                HomeBottomBar(destinations = topLevelDestinations,
                    currentDestination = navController.currentBackStackEntryAsState().value?.destination,
                    onNavigateToDestination = {
                        title.value = when (it) {
                            "sc1" -> "Screen 1"
                            "sc2" -> "Screen 2"
                            else -> {
                                "Screen 3"
                            }
                        }
                        navController.navigate(it) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            restoreState = true
                            launchSingleTop = true
                        }
                    })
            }
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            HomeNavHost(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
                navController = navController,
                startDestination = NavRoute.Screen1.route,
                navigateTo = navigateTo
            )

        }
    }

}


@Composable
fun HomeNavHost(
    modifier: Modifier,
    navController: NavHostController,
    startDestination: String,
    navigateTo: (route: String) -> Unit
) {

    NavHost(
        navController = navController, startDestination = startDestination, modifier = modifier
    ) {

        composable(route = NavRoute.Screen1.route) {
            Screen1()
        }
        composable(route = NavRoute.Screen2.route) {
            Screen2()
        }
        composable(route = NavRoute.Screen3.route) {
            Screen3()
        }


    }
}


@Composable
fun Screen1() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "One Screen", fontSize = 20.sp)
    }
}

@Composable
fun Screen2() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Two Screen", fontSize = 20.sp)
    }
}

@Composable
fun Screen3() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Three Screen", fontSize = 20.sp)
    }
}


@Composable
private fun HomeBottomBar(
    destinations: List<TopLevelDestination>,
    currentDestination: NavDestination?,
    onNavigateToDestination: (route: String) -> Unit
) {

        NavigationBar(
            modifier = Modifier
                .windowInsetsPadding(
                    WindowInsets.safeDrawing.only(WindowInsetsSides.Horizontal + WindowInsetsSides.Bottom)
                )
                .height(70.dp),
        ) {
            destinations.forEach { destination ->
                val selected =
                    currentDestination?.hierarchy?.any { it.route == destination.route } == true
                NavigationBarItem(
                    selected = selected,
                    onClick = { onNavigateToDestination(destination.route) },
                    icon = {
                        val icon = if (selected) {
                            destination.selectedIcon
                        } else {
                            destination.unselectedIcon
                        }
                        Icon(
                            imageVector = ImageVector.vectorResource(icon),
                            modifier = Modifier.size(16.dp),
                            contentDescription = null
                        )
                    },
                    label = {
                        Text(
                            text = destination.iconText
                        )
                    })
            }
        }
}