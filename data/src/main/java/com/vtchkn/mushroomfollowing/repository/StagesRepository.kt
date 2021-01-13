package com.vtchkn.mushroomfollowing.repository

import com.vtchkn.mushroomfollowing.api.usecases.GetStagesUseCase
import com.vtchkn.mushroomfollowing.viewdata.StageVD
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow

@ExperimentalCoroutinesApi
class StagesRepository(
    private val getStagesUseCase: GetStagesUseCase,
) {
    suspend fun getStages(): Flow<Result<List<StageVD?>>> {
        return getStagesUseCase.get()
    }

}