package org.cazait.cazaitandroid.feature.recentlyview.api

import org.cazait.cazaitandroid.feature.nav.CazaitNavGraph

interface RecentlyViewNavGraph : CazaitNavGraph<RecentlyViewNavGraphInfo>

data class RecentlyViewNavGraphInfo(
    val onCafeClick: (cafeId: String) -> Unit,
    val onBackButtonClick: () -> Unit,
)
