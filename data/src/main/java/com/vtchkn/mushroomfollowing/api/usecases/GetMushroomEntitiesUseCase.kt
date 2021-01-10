package com.vtchkn.mushroomfollowing.api.usecases

import android.util.Log
import com.google.firebase.database.*
import com.vtchkn.mushroomfollowing.api.model.MushroomGrowingEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetMushroomEntitiesUseCase(private val database: FirebaseDatabase) {
    companion object {
        private const val COLLECTION_NAME: String = "mushroomGrowingEntities"
        private const val TAG: String = "get${COLLECTION_NAME}"
    }

    suspend fun getList() {

        withContext(Dispatchers.IO){
            database.getReference(COLLECTION_NAME)
                .addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        val mushroomGrowingEntity: MushroomGrowingEntity? = snapshot.getValue(
                            MushroomGrowingEntity::class.java)

                        Log.d(
                            TAG,
                            mushroomGrowingEntity.toString()
                        )
                    }

                    override fun onCancelled(error: DatabaseError) {

                    }

                })

        }
    }
}