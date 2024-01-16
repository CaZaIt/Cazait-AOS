package org.cazait.cazaitandroid.feature.nav

import androidx.navigation.NavGraphBuilder

interface CazaitNavGraph<T> {
    fun buildNavGraph(navGraphBuilder: NavGraphBuilder, navInfo: T)
}
