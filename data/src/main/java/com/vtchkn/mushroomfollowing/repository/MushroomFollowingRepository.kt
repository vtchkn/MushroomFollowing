package com.vtchkn.mushroomfollowing.repository

import com.vtchkn.mushroomfollowing.api.usecases.GetMushroomEntitiesUseCase
import com.vtchkn.mushroomfollowing.viewdata.MushroomGrowingEntityVD
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow

@ExperimentalCoroutinesApi
class MushroomFollowingRepository(
    private val getMushroomEntitiesUseCase: GetMushroomEntitiesUseCase
) {

    suspend fun getMushroomGrowingEntities(): Flow<Result<List<MushroomGrowingEntityVD?>>> {
        return getMushroomEntitiesUseCase.get()
    }

}