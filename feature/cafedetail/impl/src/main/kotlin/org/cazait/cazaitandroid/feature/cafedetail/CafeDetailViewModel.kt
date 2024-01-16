package org.cazait.cazaitandroid.feature.cafedetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.cazait.cazaitandroid.core.repo.cafedetail.api.model.CafeId
import org.cazait.cazaitandroid.feature.cafedetail.usecase.GetCafeByIdUseCase
import org.cazait.cazaitandroid.feature.cafedetail.usecase.GetCafeMenusUseCase
import org.cazait.cazaitandroid.feature.cafedetail.usecase.GetCafeReviewsUseCase
import javax.inject.Inject

@HiltViewModel
internal class CafeDetailViewModel @Inject constructor(
    private val getCafeByIdUseCase: GetCafeByIdUseCase,
    private val getCafeMenusUseCase: GetCafeMenusUseCase,
    private val getCafeReviewsUseCase: GetCafeReviewsUseCase,
) : ViewModel() {
    private val _cafeDetailUiState: MutableStateFlow<CafeDetailUiState> =
        MutableStateFlow(CafeDetailUiState.Loading)
    val cafeDetailUiState = _cafeDetailUiState.asStateFlow()

    private val _errorFlow = MutableSharedFlow<Throwable>()
    val errorFlow = _errorFlow.asSharedFlow()

    fun fetchCafeDetails(cafeId: CafeId) {
        viewModelScope.launch {
            runCatching {
                val cafeDetailInfo = async { getCafeByIdUseCase(cafeId) }
                val cafeMenus = async { getCafeMenusUseCase(cafeId) }
                val cafeReviews = async { getCafeReviewsUseCase(cafeId) }

                CafeDetailUiState.Success(
                    cafeDetailInfo = cafeDetailInfo.await(),
                    menus = cafeMenus.await(),
                    reviews = cafeReviews.await(),
                )
            }.onFailure { e ->
                e.printStackTrace()
                _errorFlow.emit(e)
            }.onSuccess { success ->
                _cafeDetailUiState.update { success }
            }
        }
    }
}