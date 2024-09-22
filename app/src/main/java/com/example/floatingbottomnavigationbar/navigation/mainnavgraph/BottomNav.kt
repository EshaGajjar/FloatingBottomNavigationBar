package com.example.floatingbottomnavigationbar.navigation.mainnavgraph

import com.example.floatingbottomnavigationbar.navigation.Screen
import com.example.floatingbottomnavigationbar.R


/**
 * Sealed class representing the bottom navigation bar items.
 * @param activeIcon Resource ID for the active icon.
 * @param disableIcon Resource ID for the inactive icon.
 * @param title Title of the bottom navigation item.
 * @param route Navigation route associated with the bottom navigation item.
 */
sealed class BottomNav(
    val activeIcon: Int,
    val disableIcon: Int,
    val title: String,
    val route: String
)
{
    /**
     * Screen 1 navigation item.
     */
    data object Screen1 : BottomNav(
        activeIcon = R.drawable.ic_android,
        disableIcon = R.drawable.ic_android,
        title = "Screen 1",
        route = Screen.Screen1.route
    )


    /**
     * Screen 2 navigation item.
     */
    data object Screen2 : BottomNav(
        activeIcon = R.drawable.ic_android,
        disableIcon = R.drawable.ic_android,
        title = "Screen 2",
        route = Screen.Screen2.route
    )

    /**
     * Screen 3 navigation item.
     */
    data object Screen3 : BottomNav(
        activeIcon = R.drawable.ic_android,
        disableIcon = R.drawable.ic_android,
        title = "Screen 3",
        route = Screen.Screen3.route
    )

    /**
     * Screen 4 navigation item.
     */
    data object Screen4 : BottomNav(
        activeIcon = R.drawable.ic_android,
        disableIcon = R.drawable.ic_android,
        title = "Screen 4",
        route = Screen.Screen4.route
    )
}
