package org.cazait.cazaitandroid.feature.mypage.api

import androidx.compose.foundation.layout.PaddingValues
import org.cazait.cazaitandroid.feature.nav.CazaitNavGraph

interface MyPageNavGraph : CazaitNavGraph<MyPageNavGraphInfo>

data class MyPageNavGraphInfo(
    val padding: PaddingValues,
    val onShowErrorSnackbar: (throwable: Throwable?) -> Unit,
)
