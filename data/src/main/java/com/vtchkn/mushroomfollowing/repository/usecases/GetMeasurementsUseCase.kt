package com.vtchkn.mushroomfollowing.repository.usecases

import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.vtchkn.mushroomfollowing.data.model.Measurement
import com.vtchkn.mushroomfollowing.data.model.MushroomGrowingEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetMeasurementsUseCase(private val database: FirebaseDatabase) {
    companion object {
        private const val COLLECTION_NAME: String = "measurements"
        private const val TAG: String = "get$COLLECTION_NAME"
    }

    suspend fun getList() {

        withContext(Dispatchers.IO) {
            database.getReference(COLLECTION_NAME)
                .addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        val measurements: List<Measurement?> = snapshot.children.map {
                            it.getValue(Measurement::class.java)
                        }

                        Log.d(
                            TAG,
                            "$measurements"
                        )
                    }

                    override fun onCancelled(error: DatabaseError) {

                    }

                })

        }
    }
}