package org.cazait.cazaitandroid.feature.nav

interface CazaitTab {
    val iconResId: Int
    val iconResIdSelected: Int
    val contentDescription: String
    val route: String
    val order: Int
    val isStartDestination: Boolean
}
