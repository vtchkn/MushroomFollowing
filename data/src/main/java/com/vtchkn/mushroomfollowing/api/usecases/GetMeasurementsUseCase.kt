package com.vtchkn.mushroomfollowing.api.usecases

import com.google.firebase.database.FirebaseDatabase
import com.vtchkn.mushroomfollowing.api.mappers.MeasurementVDMapper
import com.vtchkn.mushroomfollowing.api.model.Measurement
import com.vtchkn.mushroomfollowing.base.BaseUseCase
import com.vtchkn.mushroomfollowing.viewdata.MeasurementVD

class GetMeasurementsUseCase(
    database: FirebaseDatabase?,
    measurementVDMapper: MeasurementVDMapper?,
    override val collectionName: String = COLLECTION_NAME,
    override val typeClass: Class<Measurement> = Measurement::class.java
) :
    BaseUseCase<MeasurementVD, Measurement>(database, measurementVDMapper) {
    companion object {
        private const val COLLECTION_NAME: String = "measurements"
    }

}