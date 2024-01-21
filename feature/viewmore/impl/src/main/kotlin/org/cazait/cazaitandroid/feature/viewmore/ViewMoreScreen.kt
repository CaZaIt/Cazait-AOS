package org.cazait.cazaitandroid.feature.viewmore

import android.content.Intent
import android.content.res.Configuration
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.android.gms.oss.licenses.OssLicensesMenuActivity
import org.cazait.cazaitandroid.core.designsystem.component.TopSurface
import org.cazait.cazaitandroid.core.designsystem.component.noRippleClickable
import org.cazait.cazaitandroid.core.designsystem.theme.CazaitTheme
import org.cazait.cazaitandroid.core.designsystem.theme.SunsetOrange

@Composable
internal fun ViewMoreScreen(
    padding: PaddingValues,
) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .padding(padding)
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primaryContainer),
    ) {
        TopSurface {
            Box(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = stringResource(R.string.view_more),
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .padding(top = 24.dp),
                    style = CazaitTheme.typography.titleLargeB,
                )
            }
        }
        Column(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp).padding(top = 52.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            HorizontalLine(Modifier.fillMaxWidth())
            Menu(icResId = R.drawable.ic_announcements, title = R.string.announcements) {}
            HorizontalLine(Modifier.fillMaxWidth())
            Menu(icResId = R.drawable.ic_account_management, title = R.string.account_management) {}
            HorizontalLine(Modifier.fillMaxWidth())
            Menu(icResId = R.drawable.ic_customer_support, title = R.string.customer_support) {}
            HorizontalLine(Modifier.fillMaxWidth())
            Menu(icResId = R.drawable.ic_terms_policies, title = R.string.terms_policies) {}
            HorizontalLine(Modifier.fillMaxWidth())
            Menu(icResId = R.drawable.ic_announcements, title = R.string.open_source_libraries) {
                context.startActivity(Intent(context, OssLicensesMenuActivity::class.java))
            }
            HorizontalLine(Modifier.fillMaxWidth())
        }
    }
}

@Composable
private fun Menu(
    @DrawableRes icResId: Int,
    @StringRes title: Int,
    onClick: () -> Unit,
) {
    Row(
        modifier = Modifier.fillMaxWidth().noRippleClickable { onClick() },
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            imageVector = ImageVector.vectorResource(id = icResId),
            contentDescription = stringResource(id = title),
        )
        Text(
            text = stringResource(id = title),
            style = CazaitTheme.typography.titleMediumR,
            color = MaterialTheme.colorScheme.onPrimaryContainer,
        )
    }
}

@Composable
private fun HorizontalLine(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier) {
        drawLine(
            color = SunsetOrange,
            start = Offset(0f, 0f),
            end = Offset(size.width, 0f),
            strokeWidth = 1.dp.toPx(),
        )
    }
}

@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
private fun ViewMoreScreenPreview() {
    CazaitTheme {
        ViewMoreScreen(padding = PaddingValues(0.dp))
    }
}
