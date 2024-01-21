package org.cazait.cazaitandroid.feature.map.api

import androidx.navigation.NavOptions
import org.cazait.cazaitandroid.feature.nav.CazaitNavController

interface MapNavController : CazaitNavController<MapNavControllerInfo>

data class MapNavControllerInfo(
    val navOptions: NavOptions,
)
