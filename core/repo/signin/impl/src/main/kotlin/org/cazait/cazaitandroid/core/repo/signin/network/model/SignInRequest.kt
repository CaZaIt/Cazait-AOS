package org.cazait.cazaitandroid.core.repo.signin.network.model

import kotlinx.serialization.Serializable

@Serializable
data class SignInRequest(val accountName: String, val password: String)
