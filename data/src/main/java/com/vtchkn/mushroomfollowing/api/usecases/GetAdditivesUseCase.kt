package com.vtchkn.mushroomfollowing.api.usecases

import com.google.firebase.database.FirebaseDatabase
import com.vtchkn.mushroomfollowing.api.mappers.AdditiveVDMapper
import com.vtchkn.mushroomfollowing.api.model.Additive
import com.vtchkn.mushroomfollowing.base.BaseUseCase
import com.vtchkn.mushroomfollowing.viewdata.AdditiveVD

class GetAdditivesUseCase(
    database: FirebaseDatabase?,
    addVDMapper: AdditiveVDMapper?, override val collectionName: String = COLLECTION_NAME,
    override val typeClass: Class<Additive> = Additive::class.java
) : BaseUseCase<AdditiveVD, Additive>(database, addVDMapper) {
    companion object {
        private const val COLLECTION_NAME: String = "additives"
    }

}