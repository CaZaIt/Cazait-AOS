package org.cazait.cazaitandroid.feature.map.api

import androidx.compose.foundation.layout.PaddingValues
import org.cazait.cazaitandroid.feature.nav.CazaitNavGraph

interface MapNavGraph : CazaitNavGraph<MapNavGraphInfo>

data class MapNavGraphInfo(
    val padding: PaddingValues,
    val onCafeClick: (cafeId: String) -> Unit,
    val onShowErrorSnackbar: (throwable: Throwable?) -> Unit,
)
