package com.example.floatingbottomnavigationbar.navigation

sealed class Screen(
    val route: String
) {
    data object MainScreen : Screen(route = "main_screen")

    data object Screen1 : Screen(route = "screen_1")

    data object Screen2 : Screen(route = "screen_2")

    data object Screen3 : Screen(route = "screen_3")

    data object Screen4 : Screen(route = "screen_4")
}