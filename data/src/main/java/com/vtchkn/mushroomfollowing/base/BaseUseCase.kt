package com.vtchkn.mushroomfollowing.base

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.vtchkn.mushroomfollowing.api.mappers.StageVDMapper
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.channels.sendBlocking
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

abstract class BaseUseCase<TypeVD, Type>(
    private val database: FirebaseDatabase?,
    private val mapper: Mapper<TypeVD?, Type?>?
) {
    abstract val collectionName: String

    abstract val typeClass: Class<Type>

    @ExperimentalCoroutinesApi
    suspend fun get(): Flow<Result<List<TypeVD?>>> = callbackFlow<Result<List<TypeVD?>>> {

        val postListener = object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                this@callbackFlow.sendBlocking(Result.failure(error.toException()))
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val items = dataSnapshot.children.map { ds ->
                    ds.getValue(typeClass)
                }
                this@callbackFlow.sendBlocking(Result.success(items.mapNotNull {
                    mapper?.executeMapping(
                        it
                    )
                }))
            }
        }
        database?.getReference(collectionName)
            ?.addValueEventListener(postListener)

        awaitClose {
            database?.getReference(collectionName)
                ?.removeEventListener(postListener)
        }
    }

}