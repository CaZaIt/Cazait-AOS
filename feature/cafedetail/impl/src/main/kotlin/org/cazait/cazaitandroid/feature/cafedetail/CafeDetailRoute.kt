package org.cazait.cazaitandroid.feature.cafedetail

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import java.util.UUID

@Composable
fun CafeDetailRoute(
    cafeId: UUID,
    viewModel: CafeDetailViewModel = hiltViewModel(),
) {
    CafeDetailScreen(cafeId)
}
