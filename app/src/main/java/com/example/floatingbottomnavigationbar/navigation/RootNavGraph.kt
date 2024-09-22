package com.example.floatingbottomnavigationbar.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.floatingbottomnavigationbar.ui.screen.MainScreen

@RequiresApi(Build.VERSION_CODES.P)
@Composable
fun RootNavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Screen.MainScreen.route,
        route = "main_graph"
    ) {

        composable(route = Screen.MainScreen.route) {
            MainScreen()
        }
    }
}

