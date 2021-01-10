package com.vtchkn.mushroomfollowing.repository

import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.Logger
import com.vtchkn.mushroomfollowing.api.mappers.AdditiveVDMapper
import com.vtchkn.mushroomfollowing.api.mappers.MeasurementVDMapper
import com.vtchkn.mushroomfollowing.api.mappers.SizeVDMapper
import com.vtchkn.mushroomfollowing.api.usecases.*
import com.vtchkn.mushroomfollowing.viewdata.AdditiveVD
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow

@ExperimentalCoroutinesApi
class MushroomFollowingRepository(
    private val additiveVDMapper: AdditiveVDMapper,
    private val sizeVDMapper: SizeVDMapper,
    private val measurementVDMapper: MeasurementVDMapper
) {
    private val db: FirebaseDatabase = FirebaseDatabase.getInstance()

    init {
        db.setLogLevel(Logger.Level.DEBUG)
    }

    suspend fun getMushroomGrowingEntities() {
        GetMushroomEntitiesUseCase(db).getList()
    }

    suspend fun getMeasurements() {
        GetMeasurementsUseCase(db).getList()
    }

    suspend fun getAdditives(): Flow<Result<List<AdditiveVD?>>> {
        return GetAdditivesUseCase(
            db, AdditiveVDMapper(
                SizeVDMapper(MeasurementVDMapper())
            )
        ).get()
    }

    suspend fun getSubstrates() {
        GetSubstratesUseCase(db).getList()
    }

    suspend fun getStages() {
        GetStagesUseCase(db).getList()
    }


}