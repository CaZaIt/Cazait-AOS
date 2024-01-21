package org.cazait.cazaitandroid.feature.home.api

import androidx.navigation.NavOptions
import org.cazait.cazaitandroid.feature.nav.CazaitNavController

interface HomeNavController : CazaitNavController<HomeNavControllerInfo>

data class HomeNavControllerInfo(
    val navOptions: NavOptions,
)
