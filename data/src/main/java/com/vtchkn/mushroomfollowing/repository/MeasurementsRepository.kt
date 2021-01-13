package com.vtchkn.mushroomfollowing.repository

import com.google.firebase.database.FirebaseDatabase
import com.vtchkn.mushroomfollowing.api.usecases.GetMeasurementsUseCase
import com.vtchkn.mushroomfollowing.viewdata.MeasurementVD
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow

@ExperimentalCoroutinesApi
class MeasurementsRepository(
    private val getMeasurementsUseCase: GetMeasurementsUseCase
) {

    suspend fun getMeasurements(): Flow<Result<List<MeasurementVD?>>> {
        return getMeasurementsUseCase.get()
    }

}