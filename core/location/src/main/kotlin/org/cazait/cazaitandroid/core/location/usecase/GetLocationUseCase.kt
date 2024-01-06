package org.cazait.cazaitandroid.core.location.usecase

import kotlinx.coroutines.flow.Flow
import org.cazait.cazaitandroid.core.location.LocationDetails
import org.cazait.cazaitandroid.core.location.LocationService
import javax.inject.Inject

interface GetLocationUseCase {
    operator fun invoke(): Flow<LocationDetails?>
}

internal class GetLocationUseCaseImpl @Inject constructor(
    private val locationService: LocationService,
) : GetLocationUseCase {
    override fun invoke(): Flow<LocationDetails?> = locationService.requestLocationUpdates()
}