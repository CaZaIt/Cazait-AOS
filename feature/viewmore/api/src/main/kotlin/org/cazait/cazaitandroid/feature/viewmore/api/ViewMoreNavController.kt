package org.cazait.cazaitandroid.feature.viewmore.api

import androidx.navigation.NavOptions
import org.cazait.cazaitandroid.feature.nav.CazaitNavController

interface ViewMoreNavController : CazaitNavController<ViewMoreNavControllerInfo>

data class ViewMoreNavControllerInfo(
    val navOptions: NavOptions,
)
