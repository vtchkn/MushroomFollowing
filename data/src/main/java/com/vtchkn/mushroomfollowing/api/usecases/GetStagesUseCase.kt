package com.vtchkn.mushroomfollowing.api.usecases

import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.vtchkn.mushroomfollowing.api.mappers.StageVDMapper
import com.vtchkn.mushroomfollowing.api.model.Stage
import com.vtchkn.mushroomfollowing.base.BaseUseCase
import com.vtchkn.mushroomfollowing.viewdata.StageVD
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetStagesUseCase(
    database: FirebaseDatabase?, stageVDMapper: StageVDMapper,
    override val collectionName: String = COLLECTION_NAME,
    override val typeClass: Class<Stage> = Stage::class.java
) :
    BaseUseCase<StageVD, Stage>(database, stageVDMapper) {
    companion object {
        private const val COLLECTION_NAME: String = "stages"
    }

}