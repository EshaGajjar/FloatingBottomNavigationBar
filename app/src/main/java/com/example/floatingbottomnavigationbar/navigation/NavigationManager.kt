package com.example.floatingbottomnavigationbar.navigation

import androidx.navigation.NavHostController

class NavigationManager(private val navController: NavHostController) : NavigationActionPerformer {

    override fun navigate(path: String) {
        navController.navigate(path)
    }

    override fun navigate(path: String, popupTo: NavData?) {
        navController.navigate(path){
            popupTo?.let {
                popUpTo(it.route){
                    inclusive = it.isInclusive
                    saveState = it.isSaveState
                }
            }
            launchSingleTop = true
        }
    }

    override fun popUpTo(
        path: String, isInclusive: Boolean, isSaveState: Boolean
    ) {
        navController.popBackStack(path, isInclusive, isSaveState)
    }

    override fun <T> passData(key: String, value: T): NavigationActionPerformer {
        navController.currentBackStackEntry?.savedStateHandle?.set(key, value)
        return this
    }

    override fun <T> getData(key: String): T? {
        return if (navController.currentBackStackEntry?.savedStateHandle?.contains(key) == true) {
            navController.currentBackStackEntry?.savedStateHandle?.get<T>(key)
        } else if (navController.previousBackStackEntry?.savedStateHandle?.contains(key) == true) {
            navController.previousBackStackEntry?.savedStateHandle?.get<T>(key)
        } else {
            null
        }
    }

    override fun <T> goBackWithResult(result: Pair<String, T>) {
        navController.previousBackStackEntry?.savedStateHandle?.set(result.first, result.second)
        navController.popBackStack()
    }

    override fun goBack() {
        navController.popBackStack()
    }

    override fun goBackTo(route: String) {
        navController.popBackStack(route, false)
    }

    override fun clearAndPopup(route: String){
        navController.navigate(route) {
            popUpTo(navController.graph.startDestinationId) {
                inclusive = true
            }
            launchSingleTop = true
        }
    }
}