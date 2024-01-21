package org.cazait.cazaitandroid.feature.viewmore.api

import androidx.compose.foundation.layout.PaddingValues
import org.cazait.cazaitandroid.feature.nav.CazaitNavGraph

interface ViewMoreNavGraph : CazaitNavGraph<ViewMoreNavGraphInfo>

data class ViewMoreNavGraphInfo(
    val padding: PaddingValues,
    val onShowErrorSnackbar: (Throwable?) -> Unit,
)
