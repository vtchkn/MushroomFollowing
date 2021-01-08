package com.vtchkn.mushroomfollowing.repository.usecases

import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.vtchkn.mushroomfollowing.data.model.Additive
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetAdditivesUseCase(private val database: FirebaseDatabase) {
    companion object {
        private const val COLLECTION_NAME: String = "additives"
        private const val TAG: String = "get$COLLECTION_NAME"
    }

    suspend fun getList() {

        withContext(Dispatchers.IO) {
            database.getReference(COLLECTION_NAME)
                .addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        val additives: List<Additive?> = snapshot.children.map {
                            it.getValue(Additive::class.java)
                        }

                        Log.d(
                            TAG,
                            "$additives"
                        )
                    }

                    override fun onCancelled(error: DatabaseError) {

                    }

                })

        }
    }
}