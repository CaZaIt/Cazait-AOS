package org.cazait.cazaitandroid.feature.cafedetail

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.cazait.cazaitandroid.core.designsystem.component.CazaitCard
import org.cazait.cazaitandroid.core.designsystem.theme.CazaitTheme
import org.cazait.cazaitandroid.core.model.UserId
import org.cazait.cazaitandroid.core.model.cafe.CafeName
import org.cazait.cazaitandroid.core.repo.cafedetail.api.model.CafeReview
import org.cazait.cazaitandroid.core.repo.cafedetail.api.model.ReviewContent
import org.cazait.cazaitandroid.core.repo.cafedetail.api.model.ReviewId
import org.cazait.cazaitandroid.core.repo.cafedetail.api.model.ReviewScore
import org.cazait.cazaitandroid.core.repo.cafedetail.api.model.ReviewerNickname
import java.util.UUID

@Composable
internal fun ReviewCard(
    review: CafeReview,
    modifier: Modifier = Modifier,
) {
    CazaitCard(
        modifier = modifier,
    ) {
        Column(
            modifier = Modifier
                .padding(vertical = 12.dp, horizontal = 20.dp),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 2.dp),
            ) {
                RatingBar(rating = review.score.asInt(), ratingSize = 24.dp)
                Spacer(Modifier.weight(1f))
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_emergency),
                    contentDescription = "신고 버튼",
                )
            }

            Text(
                text = review.reviewerNickname.asString(),
                style = CazaitTheme.typography.titleSmallB,
                modifier = Modifier.padding(bottom = 8.dp),
            )

            Text(
                text = review.content.asString(),
                style = CazaitTheme.typography.bodyMediumR,
            )
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
private fun PreviewMenuCard() {
    val fakeReview = CafeReview(
        userId = UserId(UUID.randomUUID()),
        reviewId = ReviewId(UUID.randomUUID()),
        cafeName = CafeName(""),
        reviewerNickname = ReviewerNickname("화양동 뚜벅초"),
        score = ReviewScore(4),
        content = ReviewContent("카페 분위기가 너무 좋네요~~ 또 오고 싶습니다."),
    )
    CazaitTheme {
        ReviewCard(
            review = fakeReview,
        )
    }
}
