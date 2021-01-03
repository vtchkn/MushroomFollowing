package com.vtchkn.mushroomfollowing.repository.usecases

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetMushroomEntitiesUseCase(private val firestore: FirebaseFirestore) {
    companion object {
        private const val COLLECTION_NAME: String = "mushroomGrowingEntities"
        private const val TAG: String = "getUseCase"
    }

    suspend fun getList() {
        withContext(Dispatchers.IO){
            firestore.collection(COLLECTION_NAME)
                .get()
                .addOnSuccessListener { result ->
                    for (document in result) {
                        Log.d(TAG, "${document.id} => ${document.data}")
                    }
                }
                .addOnFailureListener { exception ->
                    Log.w(TAG, "Error getting documents.", exception)
                }

        }
    }
}