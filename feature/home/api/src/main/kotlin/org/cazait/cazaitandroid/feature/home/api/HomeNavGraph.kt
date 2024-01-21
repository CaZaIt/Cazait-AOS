package org.cazait.cazaitandroid.feature.home.api

import androidx.compose.foundation.layout.PaddingValues
import org.cazait.cazaitandroid.feature.nav.CazaitNavGraph

interface HomeNavGraph : CazaitNavGraph<HomeNavGraphInfo>

data class HomeNavGraphInfo(
    val padding: PaddingValues,
    val onCafeClick: (cafeId: String) -> Unit,
    val onShowErrorSnackbar: (throwable: Throwable?) -> Unit,
)
