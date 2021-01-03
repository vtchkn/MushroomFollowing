package com.vtchkn.mushroomfollowing.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.vtchkn.mushroomfollowing.repository.usecases.GetMushroomEntitiesUseCase

class MushroomFollowingRepository {
    private val db: FirebaseFirestore = Firebase.firestore

    init {
        FirebaseFirestore.setLoggingEnabled(true)
    }

    suspend fun getMushroomGrowingEntities() {
        GetMushroomEntitiesUseCase(db).getList()
    }
}