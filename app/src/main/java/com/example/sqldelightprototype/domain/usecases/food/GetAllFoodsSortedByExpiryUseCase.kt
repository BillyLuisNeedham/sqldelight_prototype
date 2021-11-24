package com.example.sqldelightprototype.domain.usecases.food

import com.example.sqldelightprototype.domain.ResultOf
import com.example.sqldelightprototype.domain.models.Food
import com.example.sqldelightprototype.domain.repositories.FoodRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class GetAllFoodsSortedByExpiryUseCase @Inject constructor(
    private val foodRepository: FoodRepository
) {
    fun get(): Flow<ResultOf<List<Food>>> = foodRepository.getAllFoodsSortedByExpiry()
}
