package org.cazait.cazaitandroid.feature.home

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.cazait.cazaitandroid.core.designsystem.theme.Black
import org.cazait.cazaitandroid.core.designsystem.theme.CazaitTheme
import org.cazait.cazaitandroid.core.designsystem.theme.White

@Composable
internal fun HomeScreen(
    padding: PaddingValues,
    onClickCafe: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .padding(padding)
            .fillMaxSize(),
    ) {
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = MaterialTheme.colorScheme.background,
            shape = RoundedCornerShape(bottomStart = 40.dp, bottomEnd = 40.dp),
        ) {
            Row(
                modifier = Modifier.padding(28.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_it),
                    contentDescription = "Cazait Icon",
                    modifier = Modifier
                        .size(40.dp)
                        .align(Alignment.CenterVertically),
                )
                SearchingTextField(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_alarm_normal),
                    contentDescription = "Notification",
                    modifier = Modifier
                        .size(40.dp)
                        .align(Alignment.CenterVertically),
                )
            }
        }
    }
}

@Composable
private fun SearchingTextField(
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier,
        color = Black,
        shadowElevation = 10.dp,
        shape = RoundedCornerShape(48.dp),
    ) {
        TextField(
            shape = RoundedCornerShape(48.dp),
            value = "",
            onValueChange = {},
            placeholder = {
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_search),
                        contentDescription = "Search Icon"
                    )
                    Text(
                        text = stringResource(id = R.string.search),
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            },
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
            ),
        )
    }
}

@Composable
internal fun HomeLoading() {
}

@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
private fun HomeScreenPreview() {
    CazaitTheme {
        HomeScreen(padding = PaddingValues(0.dp), onClickCafe = {})
    }
}
