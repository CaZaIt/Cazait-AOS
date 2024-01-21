package org.cazait.cazaitandroid.feature.mypage

import android.content.res.Configuration
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.cazait.cazaitandroid.core.designsystem.component.CazaitCard
import org.cazait.cazaitandroid.core.designsystem.component.noRippleClickable
import org.cazait.cazaitandroid.core.designsystem.theme.CazaitTheme
import org.cazait.cazaitandroid.core.designsystem.theme.SunsetOrange

@Composable
internal fun MyPageScreen(
    padding: PaddingValues,
    onSignIn: () -> Unit,
    onShowErrorSnackbar: (Throwable?) -> Unit,
    viewModel: MyPageViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier.padding(padding).fillMaxSize()
            .background(color = MaterialTheme.colorScheme.primaryContainer),
    ) {
        Box(
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
        ) {
            Surface(
                modifier = Modifier.fillMaxWidth().height(140.dp),
                color = MaterialTheme.colorScheme.background,
                shape = RoundedCornerShape(bottomStart = 40.dp, bottomEnd = 40.dp),
                content = {},
            )
            Column {
                Spacer(Modifier.height(52.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.noRippleClickable {
                        if (uiState.storedUser != null) viewModel.signOut() else onSignIn()
                    },
                ) {
                    Text(
                        text = stringResource(
                            if (uiState.storedUser != null) R.string.sign_out else R.string.sign_in,
                        ),
                        style = CazaitTheme.typography.titleLargeB,
                        modifier = Modifier.padding(start = 40.dp, end = 4.dp),
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                    )
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_arrow_circle_right),
                        contentDescription = null,
                        modifier = Modifier.padding(top = 4.dp).size(24.dp),
                        tint = MaterialTheme.colorScheme.onPrimaryContainer,
                    )
                }
                Spacer(Modifier.height(16.dp))
                CazaitPaymentCard()
                MyPageFeatures()
            }
        }
    }
}

@Composable
private fun CazaitPaymentCard() {
    CazaitCard(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp).padding(bottom = 16.dp),
        color = MaterialTheme.colorScheme.primary,
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            Text(
                text = stringResource(R.string.cazait_pay),
                style = CazaitTheme.typography.titleMediumR,
                color = MaterialTheme.colorScheme.onSurface,
            )
            Row(modifier = Modifier.align(Alignment.End)) {
                Text(
                    text = "1,111",
                    style = CazaitTheme.typography.titleLargeBL.copy(fontSize = 35.sp),
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.alignByBaseline(),
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = stringResource(R.string.pament_unit),
                    style = CazaitTheme.typography.titleMediumB,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.alignByBaseline(),
                )
            }
        }
    }
}

@Composable
private fun MyPageFeatures() {
    CazaitCard(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            MyPageFeature(
                imageVectorId = R.drawable.ic_coupon,
                featureNameId = R.string.coupon,
            )
            VerticalLine()
            MyPageFeature(
                imageVectorId = R.drawable.ic_payment_details,
                featureNameId = R.string.payment_details,
            )
            VerticalLine()
            MyPageFeature(
                imageVectorId = R.drawable.ic_recent_seen_stores,
                featureNameId = R.string.recent_seen_sotres,
            )
        }
    }
}

@Composable
private fun MyPageFeature(
    @DrawableRes imageVectorId: Int,
    @StringRes featureNameId: Int,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = imageVectorId),
            contentDescription = stringResource(id = featureNameId),
            modifier = Modifier.size(64.dp),
        )
        Text(text = stringResource(id = featureNameId), style = CazaitTheme.typography.titleMediumB)
    }
}

@Composable
private fun VerticalLine() {
    Canvas(
        modifier = Modifier.height(124.dp).padding(vertical = 16.dp),
    ) {
        drawLine(
            color = SunsetOrange,
            start = Offset(0f, 0f),
            end = Offset(0f, size.height),
            strokeWidth = 1.dp.toPx(),
        )
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
private fun MyPageScreenPreview() {
    CazaitTheme {
        MyPageScreen(
            padding = PaddingValues(0.dp),
            onSignIn = {},
            onShowErrorSnackbar = {},
        )
    }
}
