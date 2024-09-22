package com.example.floatingbottomnavigationbar.navigation

interface NavigationActionPerformer {

    fun navigate(path: String)

    fun navigate(path: String, popupTo: NavData?)

    fun popUpTo(path:String,isInclusive:Boolean,isSaveState:Boolean)

    fun <T>passData(key: String,value:T): NavigationActionPerformer

    fun <T>getData(key: String): T?

    fun <T> goBackWithResult(result: Pair<String, T>)

    fun goBack()

    fun goBackTo(route: String)

    fun clearAndPopup(route: String)
}
