package com.vtchkn.mushroomfollowing.api.usecases

import com.google.firebase.database.FirebaseDatabase
import com.vtchkn.mushroomfollowing.api.mappers.SubstrateVDMapper
import com.vtchkn.mushroomfollowing.api.model.Substrate
import com.vtchkn.mushroomfollowing.base.BaseUseCase
import com.vtchkn.mushroomfollowing.viewdata.SubstrateVD

class GetSubstratesUseCase(
    database: FirebaseDatabase?,
    substrateVDMapper: SubstrateVDMapper?,
    override val collectionName: String = COLLECTION_NAME,
    override val typeClass: Class<Substrate> = Substrate::class.java
) : BaseUseCase<SubstrateVD, Substrate>(database, substrateVDMapper) {
    companion object {
        private const val COLLECTION_NAME: String = "substrates"
    }

}