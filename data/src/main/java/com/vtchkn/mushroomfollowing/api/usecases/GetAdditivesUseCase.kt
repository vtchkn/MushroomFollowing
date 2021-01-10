package com.vtchkn.mushroomfollowing.api.usecases

import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.vtchkn.mushroomfollowing.api.mappers.AdditiveVDMapper
import com.vtchkn.mushroomfollowing.api.model.Additive
import com.vtchkn.mushroomfollowing.base.BaseUseCase
import com.vtchkn.mushroomfollowing.viewdata.AdditiveVD
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.channels.sendBlocking
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.withContext

class GetAdditivesUseCase(
    database: FirebaseDatabase?,
    addVDMapper: AdditiveVDMapper
) : BaseUseCase<AdditiveVD, Additive>(database, addVDMapper) {

    override val collectionName: String = "additives"
    override val typeClass: Class<Additive> = Additive::class.java

}