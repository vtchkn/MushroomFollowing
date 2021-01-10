package com.vtchkn.mushroomfollowing.api.usecases

import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.vtchkn.mushroomfollowing.api.model.Substrate
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetSubstratesUseCase(private val database: FirebaseDatabase) {
    companion object {
        private const val COLLECTION_NAME: String = "substrates"
        private const val TAG: String = "get$COLLECTION_NAME"
    }

    suspend fun getList() {

        withContext(Dispatchers.IO) {
            database.getReference(COLLECTION_NAME)
                .addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        val substrates: List<Substrate?> = snapshot.children.map {
                            it.getValue(Substrate::class.java)
                        }

                        Log.d(
                            TAG,
                            "$substrates"
                        )
                    }

                    override fun onCancelled(error: DatabaseError) {

                    }

                })

        }
    }
}