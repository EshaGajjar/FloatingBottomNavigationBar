package com.example.floatingbottomnavigationbar.navigation.mainnavgraph

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.floatingbottomnavigationbar.ui.screen.Screen1
import com.example.floatingbottomnavigationbar.ui.screen.Screen2
import com.example.floatingbottomnavigationbar.ui.screen.Screen3
import com.example.floatingbottomnavigationbar.ui.screen.Screen4

@Composable
fun MainNavGraph(
    bottomNavController: NavHostController
) {
    NavHost(
        navController = bottomNavController,
        startDestination = BottomNav.Screen1.route,
        enterTransition = {
            slideInHorizontally(initialOffsetX = { 1000 }, animationSpec = tween(100)) + fadeIn(
                animationSpec = tween(100)
            )
        },
        exitTransition = {
            slideOutHorizontally(targetOffsetX = { -1000 }, animationSpec = tween(100)) + fadeOut(
                animationSpec = tween(100)
            )
        },
        popEnterTransition = {
            slideInHorizontally(initialOffsetX = { -1000 }, animationSpec = tween(100)) + fadeIn(
                animationSpec = tween(100)
            )
        },
        popExitTransition = {
            slideOutHorizontally(targetOffsetX = { 1000 }, animationSpec = tween(100)) + fadeOut(
                animationSpec = tween(100)
            )
        }) {
        composable(route = BottomNav.Screen1.route) {
            Screen1()
        }
        composable(route = BottomNav.Screen2.route) {
            Screen2()
        }
        composable(route = BottomNav.Screen3.route) {
            Screen3()
        }
        composable(route = BottomNav.Screen4.route) {
            Screen4()
        }
    }
}