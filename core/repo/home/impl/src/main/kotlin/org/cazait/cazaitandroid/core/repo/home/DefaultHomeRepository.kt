package org.cazait.cazaitandroid.core.repo.home

import org.cazait.cazaitandroid.core.repo.home.api.HomeRepository
import org.cazait.cazaitandroid.core.repo.home.api.model.CongestionCafes
import javax.inject.Inject

internal class DefaultHomeRepository @Inject constructor(

) : HomeRepository {
    override suspend fun getAllCongestionCafes(): CongestionCafes {
        TODO("Not yet implemented")
    }
}