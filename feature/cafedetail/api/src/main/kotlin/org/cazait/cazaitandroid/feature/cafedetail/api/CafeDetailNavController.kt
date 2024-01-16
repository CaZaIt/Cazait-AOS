package org.cazait.cazaitandroid.feature.cafedetail.api

import org.cazait.cazaitandroid.feature.nav.CazaitNavController

interface CafeDetailNavController : CazaitNavController<CafeDetailNavControllerInfo>

data class CafeDetailNavControllerInfo(
    val cafeId: String,
)

interface ReviewEditorNavController : CazaitNavController<ReviewEditorNavControllerInfo>

data class ReviewEditorNavControllerInfo(
    val cafeId: String,
)
