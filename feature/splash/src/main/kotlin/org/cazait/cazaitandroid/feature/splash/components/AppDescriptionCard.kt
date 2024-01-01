package org.cazait.cazaitandroid.feature.splash.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.cazait.cazaitandroid.core.designsystem.theme.CazaitTheme
import org.cazait.cazaitandroid.core.designsystem.theme.SunsetOrange
import org.cazait.cazaitandroid.core.designsystem.theme.surfaceDim
import org.cazait.cazaitandroid.feature.splash.R

@Composable
internal fun AppDescriptionCard(
    onClickStart: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val cardTitle = stringResource(id = R.string.app_description_title)
    val annotatedString = buildAnnotatedString {
        withStyle(SpanStyle(color = SunsetOrange)) { append(cardTitle.substring(0, 1)) }
        withStyle(SpanStyle(color = MaterialTheme.colorScheme.onPrimaryContainer)) {
            append(
                cardTitle.substring(1, 4),
            )
        }
        withStyle(SpanStyle(color = SunsetOrange)) { append(cardTitle.substring(4, 5)) }
        withStyle(SpanStyle(color = MaterialTheme.colorScheme.onPrimaryContainer)) {
            append(
                cardTitle.substring(5, 7),
            )
        }
        withStyle(SpanStyle(color = SunsetOrange)) { append(cardTitle.substring(7, 8)) }
        withStyle(SpanStyle(color = MaterialTheme.colorScheme.onPrimaryContainer)) {
            append(
                cardTitle.substring(8, cardTitle.length),
            )
        }
    }
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
        color = MaterialTheme.colorScheme.surfaceDim,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 74.dp, bottom = 84.dp)
                .padding(horizontal = 48.dp),
        ) {
            Text(
                text = annotatedString,
                style = CazaitTheme.typography.displayLargeR,
            )
            Spacer(modifier = Modifier.height(17.dp))
            Text(
                text = stringResource(id = R.string.app_description_description),
                style = CazaitTheme.typography.titleMediumR,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
            )
            Spacer(modifier = Modifier.height(44.dp))
            Button(
                onClick = { onClickStart() },
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource(id = R.string.app_description_start),
                    style = CazaitTheme.typography.titleLargeB,
                    color = MaterialTheme.colorScheme.onPrimary,
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}

@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
private fun AppDescriptionCardPreview() {
    CazaitTheme {
        AppDescriptionCard(
            onClickStart = {},
        )
    }
}
