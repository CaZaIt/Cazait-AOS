package org.cazait.cazaitandroid.feature.cafedetail

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import java.util.UUID

@Composable
fun CafeDetailScreen(
    cafeId: UUID,
) {
    Text(text = cafeId.toString())
}