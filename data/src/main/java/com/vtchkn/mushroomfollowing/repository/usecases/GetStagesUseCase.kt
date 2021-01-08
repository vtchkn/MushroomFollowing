package com.vtchkn.mushroomfollowing.repository.usecases

import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.vtchkn.mushroomfollowing.data.model.Additive
import com.vtchkn.mushroomfollowing.data.model.Measurement
import com.vtchkn.mushroomfollowing.data.model.MushroomGrowingEntity
import com.vtchkn.mushroomfollowing.data.model.Stage
import com.vtchkn.mushroomfollowing.repository.model.Substrate
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetStagesUseCase(private val database: FirebaseDatabase) {
    companion object {
        private const val COLLECTION_NAME: String = "stages"
        private const val TAG: String = "get$COLLECTION_NAME"
    }

    suspend fun getList() {

        withContext(Dispatchers.IO) {
            database.getReference(COLLECTION_NAME)
                .addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        val stages: List<Stage?> = snapshot.children.map {
                            it.getValue(Stage::class.java)
                        }

                        Log.d(
                            TAG,
                            "$stages"
                        )
                    }

                    override fun onCancelled(error: DatabaseError) {

                    }

                })

        }
    }
}