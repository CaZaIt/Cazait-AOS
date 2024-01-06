package org.cazait.cazaitandroid.core.repo.cafedetail.mapper

import org.cazait.cazaitandroid.core.repo.cafedetail.api.model.CafeName
import org.cazait.cazaitandroid.core.repo.cafedetail.api.model.CafeReview
import org.cazait.cazaitandroid.core.repo.cafedetail.api.model.ReviewContent
import org.cazait.cazaitandroid.core.repo.cafedetail.api.model.ReviewId
import org.cazait.cazaitandroid.core.repo.cafedetail.api.model.ReviewScore
import org.cazait.cazaitandroid.core.repo.cafedetail.api.model.ReviewerNickname
import org.cazait.cazaitandroid.core.repo.cafedetail.api.model.UserId
import org.cazait.cazaitandroid.core.repo.cafedetail.network.model.CafeReviewResponse
import java.util.UUID

internal fun CafeReviewResponse.toData(): CafeReview = CafeReview(
    userId = UserId(UUID.fromString(userId)),
    reviewId = ReviewId(UUID.fromString(reviewId)),
    cafeName = CafeName(cafeName),
    reviewerNickname = ReviewerNickname(nickname),
    score = ReviewScore(score),
    content = ReviewContent(content),
)