package org.cazait.cazaitandroid.feature.cafedetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
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
        MutableStateFlow(CafeDetailUiState())
    val cafeDetailUiState = _cafeDetailUiState.asStateFlow()

    private val _errorFlow = MutableSharedFlow<Throwable>()
    val errorFlow = _errorFlow.asSharedFlow()

    fun fetchCafeDetails(cafeId: CafeId) {
        viewModelScope.launch {
            launch {
                flow { emit(getCafeByIdUseCase(cafeId)) }.map(CafeDetailInfoUiState::Success)
                    .catch {
                        it.printStackTrace()
                        _errorFlow.emit(it)
                    }
                    .collect { success ->
                        _cafeDetailUiState.update { it.copy(cafeDetailInfoUiState = success) }
                    }
            }
            launch {
                flow { emit(getCafeMenusUseCase(cafeId)) }.map(CafeDetailMenuUiState::Success)
                    .catch {
                        it.printStackTrace()
                        _errorFlow.emit(it)
                    }
                    .collect { success ->
                        _cafeDetailUiState.update { it.copy(menuUiState = success) }
                    }
            }
            launch {
                flow { emit(getCafeReviewsUseCase(cafeId)) }.map(CafeDetailReviewUiState::Success)
                    .catch {
                        it.printStackTrace()
                        _errorFlow.emit(it)
                    }
                    .collect { success ->
                        _cafeDetailUiState.update { it.copy(reviewUiState = success) }
                    }
            }
        }
    }

    fun switchTab() {
        _cafeDetailUiState.update { it.copy(currentTab = it.currentTab.switch()) }
    }
}