package com.vtchkn.mushroomfollowing.repository

import com.vtchkn.mushroomfollowing.api.usecases.GetAdditivesUseCase
import com.vtchkn.mushroomfollowing.viewdata.AdditiveVD
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow

@ExperimentalCoroutinesApi
class AdditivesRepository(
    private val getAdditivesUseCase: GetAdditivesUseCase
) {

    suspend fun getAdditives(): Flow<Result<List<AdditiveVD?>>> {
        return getAdditivesUseCase.get()
    }

}