package org.cazait.cazaitandroid.feature.recentlyview

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.cazait.cazaitandroid.core.designsystem.component.NetworkImage
import org.cazait.cazaitandroid.core.designsystem.theme.CazaitTheme
import org.cazait.cazaitandroid.core.repo.recentlyview.api.model.CafeAddress
import org.cazait.cazaitandroid.core.repo.recentlyview.api.model.CafeId
import org.cazait.cazaitandroid.core.repo.recentlyview.api.model.CafeImages
import org.cazait.cazaitandroid.core.repo.recentlyview.api.model.CafeName
import org.cazait.cazaitandroid.core.repo.recentlyview.api.model.Latitude
import org.cazait.cazaitandroid.core.repo.recentlyview.api.model.Longitude
import org.cazait.cazaitandroid.core.repo.recentlyview.api.model.RecentlyViewedCafe
import java.util.UUID

@Composable
internal fun RecentlyViewedCafeCard(
    cafe: RecentlyViewedCafe,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.primaryContainer,
        shape = RoundedCornerShape(size = 12.dp),
        onClick = onClick,
    ) {
        Row(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            NetworkImage(
                imageUrl = cafe.cafeImages.first?.asString(),
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(144.dp).align(Alignment.CenterVertically),
            )
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(text = cafe.name.asString(), style = CazaitTheme.typography.titleLargeB)
                Spacer(Modifier.height(8.dp))
                Text(text = cafe.address.asString(), style = CazaitTheme.typography.bodyMediumR)
                Spacer(Modifier.weight(1f))
                Button(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    onClick = {},
                ) { Text(text = stringResource(R.string.view_more_cafe)) }
            }
        }
    }
}

@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
private fun RecentlyViewedCafeCardPreview() {
    CazaitTheme {
        RecentlyViewedCafeCard(
            modifier = Modifier.size(348.dp, 180.dp),
            cafe = RecentlyViewedCafe(
                id = CafeId(UUID.randomUUID()),
                name = CafeName("롬곡"),
                address = CafeAddress("서울특별시 어딘가 좋은곳에 위치함"),
                cafeImages = CafeImages(emptyList()),
                latitude = Latitude(0.0),
                longitude = Longitude(0.0),
            ),
            onClick = {},
        )
    }
}
