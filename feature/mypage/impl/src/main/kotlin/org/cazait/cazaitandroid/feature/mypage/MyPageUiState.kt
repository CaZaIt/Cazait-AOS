package org.cazait.cazaitandroid.feature.mypage

import org.cazait.cazaitandroid.core.repo.signin.api.model.StoredUser

data class MyPageUiState(
    val storedUser: StoredUser?,
)
