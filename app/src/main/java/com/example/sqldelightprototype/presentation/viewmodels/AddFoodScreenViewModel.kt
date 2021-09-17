package com.example.sqldelightprototype.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sqldelightprototype.domain.ResultOf
import com.example.sqldelightprototype.domain.models.Food
import com.example.sqldelightprototype.domain.usecases.AddFoodUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddFoodScreenViewModel @Inject constructor(
    private val addFoodUseCase: AddFoodUseCase
) : ViewModel() {

    private val _uploadState: MutableStateFlow<ResultOf<Unit>?> = MutableStateFlow(null)
    val uploadState: StateFlow<ResultOf<Unit>?> = _uploadState


    fun addFood(food: Food) {
        viewModelScope.launch {
            _uploadState.value = ResultOf.Loading
            _uploadState.value = addFoodUseCase.add(food = food)
        }
    }

}