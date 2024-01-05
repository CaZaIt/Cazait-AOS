package org.cazait.cazaitandroid.core.repo.home.api

import org.cazait.cazaitandroid.core.repo.home.api.model.CongestionCafes

interface HomeRepository {
    suspend fun getAllCongestionCafes(): CongestionCafes
}