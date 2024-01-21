package org.cazait.cazaitandroid.feature.main

import androidx.compose.runtime.Immutable
import org.cazait.cazaitandroid.feature.nav.CazaitTab
import javax.inject.Inject

@Immutable
class MainTabs @Inject constructor(
    private val tabs: Set<@JvmSuppressWildcards CazaitTab>,
) {
    val tabList: List<CazaitTab> = tabs.sortedBy { it.order }
    val startDestination: String = tabs.first { it.isStartDestination }.route

    fun find(route: String): CazaitTab? = tabs.firstOrNull { it.route == route }

    operator fun contains(route: String): Boolean = tabs.any { it.route == route }
}
