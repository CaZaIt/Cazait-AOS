package org.cazait.cazaitandroid.core.repo.cafedetail.api.model

data class CafeReview(
    val userId: UserId,
    val reviewId: ReviewId,
    val cafeName: CafeName,
    val reviewerNickname: ReviewerNickname,
    val score: ReviewScore,
    val content: ReviewContent,
)

@JvmInline
value class CafeReviews(private val reviews: List<CafeReview>) {
    fun asList(): List<CafeReview> = reviews
}
