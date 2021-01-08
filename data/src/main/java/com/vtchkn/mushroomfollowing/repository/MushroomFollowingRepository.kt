package com.vtchkn.mushroomfollowing.repository

import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.Logger
import com.vtchkn.mushroomfollowing.repository.usecases.*

class MushroomFollowingRepository {
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

    suspend fun getAdditives() {
        GetAdditivesUseCase(db).getList()
    }

    suspend fun getSubstrates() {
        GetSubstratesUseCase(db).getList()
    }

    suspend fun getStages() {
        GetStagesUseCase(db).getList()
    }


}