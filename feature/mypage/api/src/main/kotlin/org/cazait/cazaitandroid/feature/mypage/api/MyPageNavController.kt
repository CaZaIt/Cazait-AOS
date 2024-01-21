package org.cazait.cazaitandroid.feature.mypage.api

import androidx.navigation.NavOptions
import org.cazait.cazaitandroid.feature.nav.CazaitNavController

interface MyPageNavController : CazaitNavController<MyPageNavControllerInfo>

data class MyPageNavControllerInfo(
    val navOptions: NavOptions,
)
