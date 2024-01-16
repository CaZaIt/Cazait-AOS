package org.cazait.cazaitandroid.feature.cafedetail

import android.widget.RatingBar
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
internal fun RatingBar(
    rating: Int,
    ratingSize: Dp,
    modifier: Modifier = Modifier,
    maxRating: Int = 5,
    onRatingChanged: (Int) -> Unit = {},
) {
    Row(modifier = modifier) {
        repeat(maxRating) { count ->
            Image(
                imageVector = ImageVector.vectorResource(
                    id = if (count < rating) R.drawable.ic_star_fill else R.drawable.ic_star
                ),
                contentDescription = "별점",
                modifier = Modifier
                    .size(ratingSize)
                    .clickable { onRatingChanged(count) }
            )
        }
    }
}

@Preview
@Composable
private fun PreviewRatingBar() {
    RatingBar(
        rating = 4,
        ratingSize = 24.dp,
    )
}