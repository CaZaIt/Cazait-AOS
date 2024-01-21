package org.cazait.cazaitandroid.feature.nav

import androidx.navigation.NavController

interface CazaitNavController<T> {
    val route: String
    fun navigate(navController: NavController, navInfo: T)
}
