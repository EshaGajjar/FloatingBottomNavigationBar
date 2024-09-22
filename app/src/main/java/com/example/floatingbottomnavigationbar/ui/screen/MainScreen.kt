package com.example.floatingbottomnavigationbar.ui.screen

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.isImeVisible
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.BottomNavigation
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.floatingbottomnavigationbar.navigation.mainnavgraph.BottomNav
import com.example.floatingbottomnavigationbar.navigation.mainnavgraph.MainNavGraph
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun MainScreen() {
    MainScreenBottomNavBar()
}

@OptIn(ExperimentalLayoutApi::class, ExperimentalFoundationApi::class)
@Composable
fun MainScreenBottomNavBar() {

    val isImeVisible = WindowInsets.isImeVisible
    val bottomNavController = rememberNavController()
    val bottomNavBarBgColor = Color.Black
    
    Scaffold(
        bottomBar = {
                Box(
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
                        .clip(
                            RoundedCornerShape(16.dp)
                        )
                        .background(bottomNavBarBgColor)
                ) {
                    BottomBar(
                        navController = bottomNavController
                    )
                }
        },
        modifier = Modifier
            .background(color = bottomNavBarBgColor)
            .systemBarsPadding()
    )
    { innerPadding ->
        Log.d("Esha_test", "innerPadding : $innerPadding")
        val contentPadding = remember(isImeVisible) {
            if (isImeVisible)
                PaddingValues(start = 0.0.dp, top = 0.0.dp, end = 0.0.dp, bottom = 56.0.dp)
            else
                PaddingValues(start = 0.0.dp, top = 0.0.dp, end = 0.0.dp, bottom = 0.0.dp)
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)
        ) {
            MainNavGraph(bottomNavController = bottomNavController)
        }
    }

}


@ExperimentalFoundationApi
@Composable
fun BoxScope.BottomBar(
    navController: NavHostController
) {
    val screens = listOf(
        BottomNav.Screen1,
        BottomNav.Screen2,
        BottomNav.Screen3,
        BottomNav.Screen4,
    )

    // Get the current back stack entry to determine the current destination
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    // Define the BottomNavigation composable
    BottomNavigation(
        backgroundColor = Color.Black,
        modifier = Modifier
            .align(Alignment.BottomCenter)
    ) {
        // Iterate through each screen and add it to the BottomNavigation
        screens.forEachIndexed { _, screen ->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }
}


@ExperimentalFoundationApi
@Composable
fun RowScope.AddItem(
    screen: BottomNav,
    currentDestination: NavDestination?,
    navController: NavHostController,
) {
    // Check if the current destination matches the route of the screen
    val selected = currentDestination?.hierarchy?.any {
        it.route == screen.route
    } == true

    BottomNavigationItem(
        modifier = Modifier.align(Alignment.CenterVertically),
        label = {
            Text(
                text = screen.title,
                fontSize = 12.sp,
                letterSpacing = 0.sp,
                fontFamily = FontFamily.SansSerif,
                color = if (selected) Color.Yellow else Color.LightGray,
                softWrap = false,
            )
        },
        icon = {
            Icon(
                painter = painterResource(id = if (selected) screen.activeIcon else screen.disableIcon),
                contentDescription = "Navigation Icon",
                tint = if (selected) Color.Yellow else Color.LightGray,
                modifier = Modifier.height(24.dp).width(24.dp)
            )
        },
        selected = selected,
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true // Save the state of the destination
                }
                launchSingleTop = true // Avoid multiple copies of the same destination
                restoreState = true // Restore the previous state if it exists
            }
        },
        interactionSource = remember { MutableInteractionSource() }, // Handle interaction source
        selectedContentColor = Color.Unspecified, // Use default colors
        unselectedContentColor = Color.Unspecified // Use default colors
    )
}


@Composable
fun SetStatusBarColor(statusBarColor: Color, navigationBarColor: Color) {
    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(color = statusBarColor)
    systemUiController.setNavigationBarColor(color = navigationBarColor)
}