package com.vtchkn.mushroomfollowing.api.usecases

import com.google.firebase.database.FirebaseDatabase
import com.vtchkn.mushroomfollowing.api.mappers.MushroomGrowingEntityVDMapper
import com.vtchkn.mushroomfollowing.api.model.MushroomGrowingEntity
import com.vtchkn.mushroomfollowing.base.BaseUseCase
import com.vtchkn.mushroomfollowing.viewdata.MushroomGrowingEntityVD

class GetMushroomEntitiesUseCase(
    database: FirebaseDatabase?,
    mushroomGrowingEntityVDMapper: MushroomGrowingEntityVDMapper?,
    override val collectionName: String = COLLECTION_NAME,
    override val typeClass: Class<MushroomGrowingEntity> = MushroomGrowingEntity::class.java
) : BaseUseCase<MushroomGrowingEntityVD, MushroomGrowingEntity>(
    database,
    mushroomGrowingEntityVDMapper
) {

    companion object {
        private const val COLLECTION_NAME: String = "mushroomGrowingEntities"
    }

}