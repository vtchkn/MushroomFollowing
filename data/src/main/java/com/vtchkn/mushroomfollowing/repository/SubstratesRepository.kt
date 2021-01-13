package com.vtchkn.mushroomfollowing.repository

import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.Logger
import com.vtchkn.mushroomfollowing.api.mappers.*
import com.vtchkn.mushroomfollowing.api.usecases.*
import com.vtchkn.mushroomfollowing.viewdata.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow

@ExperimentalCoroutinesApi
class SubstratesRepository(
    private val getSubstratesUseCase: GetSubstratesUseCase
) {

    suspend fun getSubstrates(): Flow<Result<List<SubstrateVD?>>> {
        return getSubstratesUseCase.get()
    }

}