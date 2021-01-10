package com.vtchkn.mushroomfollowing.repository

import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.Logger
import com.vtchkn.mushroomfollowing.api.mappers.*
import com.vtchkn.mushroomfollowing.api.usecases.*
import com.vtchkn.mushroomfollowing.viewdata.AdditiveVD
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow

@ExperimentalCoroutinesApi
class MushroomFollowingRepository(
    private val raceVDMapper: RaceVDMapper?,
    private val substrateVDMapper: SubstrateVDMapper?,
    private val stageVDMapper: StageVDMapper,
    private val sizeVDMapper: SizeVDMapper,
    private val additiveVDMapper: AdditiveVDMapper,
    private val originVDMapper: OriginVDMapper,
    private val flushVDMapper: FlushVDMapper,
    private val deathReasonVDMapper: DeathReasonVDMapper,
    private val mushroomGrowingEntityVDMapper: MushroomGrowingEntityVDMapper,
    private val db: FirebaseDatabase?
) {

    init {
        db?.setLogLevel(Logger.Level.DEBUG)
    }

    suspend fun getMushroomGrowingEntities() {
//        GetMushroomEntitiesUseCase(db).getList()
    }

    suspend fun getMeasurements() {
//        GetMeasurementsUseCase(db).getList()
    }

    suspend fun getAdditives(): Flow<Result<List<AdditiveVD?>>> {
        return GetAdditivesUseCase(
            db, additiveVDMapper
        ).get()
    }

    suspend fun getSubstrates() {
//        GetSubstratesUseCase(db).getList()
    }

    suspend fun getStages() {
//        GetStagesUseCase(db).getList()
    }


}