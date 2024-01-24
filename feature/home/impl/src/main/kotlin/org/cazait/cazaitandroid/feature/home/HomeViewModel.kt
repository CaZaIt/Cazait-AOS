package org.cazait.cazaitandroid.feature.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.cazait.cazaitandroid.core.httphandle.CazaitHttpException
import org.cazait.cazaitandroid.core.local.user.StoredUser
import org.cazait.cazaitandroid.core.local.user.usecase.GetStoredUserInformationUseCase
import org.cazait.cazaitandroid.core.local.user.usecase.UpdateStoredUserInformationUseCase
import org.cazait.cazaitandroid.core.location.LocationDetails
import org.cazait.cazaitandroid.core.location.usecase.GetLocationUseCase
import org.cazait.cazaitandroid.core.repo.home.api.model.Cafe
import org.cazait.cazaitandroid.core.repo.home.api.model.DistanceLimit
import org.cazait.cazaitandroid.core.repo.home.api.model.Latitude
import org.cazait.cazaitandroid.core.repo.home.api.model.Longitude
import org.cazait.cazaitandroid.core.repo.home.api.model.SortBy
import org.cazait.cazaitandroid.feature.home.usecase.GetCongestionCafesUseCase
import org.cazait.cazaitandroid.feature.home.usecase.GetFavoritedCafesUseCase
import org.cazait.cazaitandroid.feature.home.usecase.GetRefreshAccessTokenUseCase
import org.cazait.cazaitandroid.feature.home.usecase.StoreViewedCafeUseCase
import javax.inject.Inject

@HiltViewModel
internal class HomeViewModel @Inject constructor(
    private val getLocationUseCase: GetLocationUseCase,
    private val storeViewedCafeUseCase: StoreViewedCafeUseCase,
    private val getFavoritedCafesUseCase: GetFavoritedCafesUseCase,
    private val getCongestionCafesUseCase: GetCongestionCafesUseCase,
    private val getRefreshAccessTokenUseCase: GetRefreshAccessTokenUseCase,
    private val getStoredUserInformationUseCase: GetStoredUserInformationUseCase,
    private val updateStoredUserInformationUseCase: UpdateStoredUserInformationUseCase,
) : ViewModel() {
    private val _errorFlow = MutableSharedFlow<Throwable>()
    val errorFlow = _errorFlow.asSharedFlow()

    private val _currentLocation = MutableStateFlow(LocationDetails(37.5538202, 127.0832242))
    val currentLocation = _currentLocation.asStateFlow()

    private val _uiState: MutableStateFlow<HomeAllCafesUiState> =
        MutableStateFlow(HomeAllCafesUiState.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        fetchFavoritedCafes()
    }

    fun handlePermission(event: PermissionEvent) {
        when (event) {
            PermissionEvent.Granted -> {
                viewModelScope.launch {
                    var isFirstLocationCollected = false
                    getLocationUseCase().collect { location ->
                        _currentLocation.update {
                            location ?: LocationDetails(
                                37.5538202,
                                127.0832242,
                            )
                        }
                        if (!isFirstLocationCollected) {
                            fetchCongestionCafes()
                            isFirstLocationCollected = true
                        }
                    }
                }
            }

            PermissionEvent.Revoked -> {
                _uiState.update { HomeAllCafesUiState.RevokedPermissions }
            }
        }
    }

    fun storeViewedCafe(cafe: Cafe) {
        viewModelScope.launch {
            storeViewedCafeUseCase(cafe)
        }
    }

    private fun fetchFavoritedCafes() {
        viewModelScope.launch {
            val user: StoredUser = getStoredUserInformationUseCase().filterNotNull().first()
            flow { emit(getFavoritedCafesUseCase(user.userId, user.accessToken)) }
                .catch {
                    if (it is CazaitHttpException && it.code == 401) {
                        handleTokenExpired(user) { fetchFavoritedCafes() }
                    }
                }
                .collect { cafes ->
                    Log.e("HomeViewModel", "cafes = ${cafes.asList()}")
                }
        }
    }

    private suspend fun handleTokenExpired(user: StoredUser, onRefreshed: () -> Unit) {
        try {
            val updatedUser = getRefreshAccessTokenUseCase(user.accessToken, user.refreshToken)
            updateStoredUserInformationUseCase(
                user.copy(
                    accessToken = updatedUser.accessToken,
                    refreshToken = updatedUser.refreshToken,
                ),
            )
            onRefreshed()
        } catch (e: Exception) {
            _errorFlow.emit(e)
        }
    }

    private fun fetchCongestionCafes(
        sortBy: SortBy = SortBy.DISTANCE,
        limit: DistanceLimit = DistanceLimit(2000),
    ) {
        viewModelScope.launch {
            flow {
                emit(
                    getCongestionCafesUseCase(
                        latitude = Latitude(_currentLocation.value.latitude),
                        longitude = Longitude(_currentLocation.value.longitude),
                        sortBy = sortBy,
                        limit = limit,
                    ),
                )
            }
                .map(HomeAllCafesUiState::Success)
                .catch {
                    it.printStackTrace()
                    _errorFlow.emit(it)
                }
                .collect { success ->
                    _uiState.update { success }
                }
        }
    }
}
