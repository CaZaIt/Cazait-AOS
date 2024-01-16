package org.cazait.cazaitandroid.feature.cafedetail.api

import org.cazait.cazaitandroid.feature.nav.CazaitNavGraph

interface CafeDetailNavGraph : CazaitNavGraph<CafeDetailNavGraphInfo>

data class CafeDetailNavGraphInfo(
    val onEditReviewClick: (cafeId: String) -> Unit,
    val onBackButtonClick: () -> Unit,
    val onNavArgError: () -> Unit,
    val onShowErrorSnackbar: (throwable: Throwable?) -> Unit,
)
