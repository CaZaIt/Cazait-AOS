package org.cazait.cazaitandroid.feature.home.component

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.cazait.cazaitandroid.core.designsystem.component.CazaitCard
import org.cazait.cazaitandroid.core.designsystem.component.NetworkImage
import org.cazait.cazaitandroid.core.designsystem.theme.CazaitTheme
import org.cazait.cazaitandroid.core.repo.home.api.model.Cafe
import org.cazait.cazaitandroid.core.repo.home.api.model.CafeAddress
import org.cazait.cazaitandroid.core.repo.home.api.model.CafeId
import org.cazait.cazaitandroid.core.repo.home.api.model.CafeImages
import org.cazait.cazaitandroid.core.repo.home.api.model.CafeName
import org.cazait.cazaitandroid.core.repo.home.api.model.Congestion
import org.cazait.cazaitandroid.core.repo.home.api.model.CongestionCafe
import org.cazait.cazaitandroid.core.repo.home.api.model.Latitude
import org.cazait.cazaitandroid.core.repo.home.api.model.Longitude
import org.cazait.cazaitandroid.feature.home.R
import java.util.UUID

@Composable
internal fun HomeCongestionCafeItem(
    congestionCafe: CongestionCafe,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    CazaitCard(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp)
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            NetworkImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(124.dp),
                imageUrl = congestionCafe.cafe.cafeImages.asList().getOrNull(0)?.asString()
            )
            Spacer(modifier = Modifier.height(12.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
            ) {
                Row {
                    Text(
                        text = congestionCafe.cafe.name.asString(),
                        style = CazaitTheme.typography.titleLargeB
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = congestionCafe.cafe.address.asString(),
                    style = CazaitTheme.typography.bodyMediumR,
                    minLines = 2,
                    maxLines = 2,
                )
                Spacer(modifier = Modifier.height(12.dp))
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = onClick,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onPrimary,
                    ),
                    shape = RoundedCornerShape(48.dp),
                ) {
                    Text(
                        text = stringResource(id = congestionCafe.congestion.toStringRes()),
                        style = CazaitTheme.typography.titleLargeB
                    )
                }
            }
        }
    }
}

private fun Congestion.toStringRes(): Int = when (this) {
    Congestion.FREE -> R.string.congestion_free
    Congestion.CLOSE -> R.string.congestion_close
    Congestion.NORMAL -> R.string.congestion_normal
    Congestion.CROWDED -> R.string.congestion_crowded
    Congestion.VERY_CROWDED -> R.string.congestion_very_crowded
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
private fun PreviewHomeCongestionCafeItem() {
    CazaitTheme {
        HomeCongestionCafeItem(
            congestionCafe = CongestionCafe(
                cafe = Cafe(
                    id = CafeId(UUID.randomUUID()),
                    name = CafeName("카자잇"),
                    address = CafeAddress("서울시 광진구 광나루로 111-1 1층"),
                    cafeImages = CafeImages(emptyList()),
                    latitude = Latitude(0.0),
                    longitude = Longitude(0.0),
                ),
                congestion = Congestion.FREE,
            ),
            onClick = {},
        )
    }
}