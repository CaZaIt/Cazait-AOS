package org.cazait.cazaitandroid.feature.cafedetail

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.cazait.cazaitandroid.core.designsystem.component.CazaitBackTopBar
import org.cazait.cazaitandroid.core.designsystem.component.SecondaryButton
import org.cazait.cazaitandroid.core.designsystem.theme.CazaitTheme
import org.cazait.cazaitandroid.core.designsystem.theme.Gray01

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReviewEditorScreen(
//    cafeId: UUID,
    onBackButtonClick: () -> Unit,
//    onShowErrorSnackbar: (throwable: Throwable?) -> Unit,
//    viewModel: ReviewEditorViewModel = hiltViewModel(),
) {
    var editedReview by remember { mutableStateOf("") }
    var editedRating by remember { mutableIntStateOf(5) }

    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        CazaitBackTopBar(
            title = R.string.edit_review,
            onBackButtonClick = onBackButtonClick,
        )
    }) { contentPadding ->
        Column(
            modifier = Modifier
                .padding(contentPadding)
                .fillMaxSize()
                .padding(horizontal = 28.dp)
                .padding(
                    top = 44.dp,
                ),
        ) {
            Text(
                text = stringResource(R.string.review_editor_guide1),
                style = CazaitTheme.typography.titleMediumB,
                modifier = Modifier.padding(bottom = 4.dp),
            )
            RatingBar(
                rating = editedRating,
                ratingSize = 56.dp,
                modifier = Modifier.padding(bottom = 28.dp),
                onRatingChanged = { editedRating = it },
            )
            Text(
                text = stringResource(R.string.review_editor_guide2),
                style = CazaitTheme.typography.titleMediumB,
                modifier = Modifier.padding(bottom = 16.dp),
            )
            TextField(
                value = editedReview,
                onValueChange = { editedReview = it },
                shape = RoundedCornerShape(24.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 48.dp),
                placeholder = {
                    Text(
                        text = stringResource(R.string.review_editor_guide3),
                        style = MaterialTheme.typography.bodyMedium,
                    )
                },
                minLines = 10,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                    unfocusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    unfocusedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    unfocusedPlaceholderColor = Gray01,
                ),
            )
            SecondaryButton(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                onClick = { /* viewModel.editReview(cafeId, editedRating, editedReview) */ },
            ) {
                Text(
                    text = stringResource(R.string.do_edit),
                    style = CazaitTheme.typography.titleMediumB,
                    modifier = Modifier.padding(horizontal = 8.dp),
                )
            }
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
private fun PreviewReviewEditorScreen() {
    CazaitTheme {
        ReviewEditorScreen(
//            cafeId = UUID.randomUUID(),
//            onShowErrorSnackbar = {},
            onBackButtonClick = {},
        )
    }
}
