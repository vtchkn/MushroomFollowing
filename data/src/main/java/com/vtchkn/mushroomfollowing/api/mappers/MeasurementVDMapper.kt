package com.vtchkn.mushroomfollowing.api.mappers

import com.vtchkn.mushroomfollowing.api.model.Measurement
import com.vtchkn.mushroomfollowing.base.Mapper
import com.vtchkn.mushroomfollowing.viewdata.MeasurementVD

class MeasurementVDMapper : Mapper<MeasurementVD?, Measurement?>() {
    override fun executeMapping(type: Measurement?): MeasurementVD? {
        return type?.run {
            MeasurementVD(name = name, type = type(this.type))
        }
    }

    fun type(type: String?): MeasurementVD.Type {
        return when (type) {
            MeasurementVD.Type.GRAM.value -> MeasurementVD.Type.GRAM
            MeasurementVD.Type.MILLILITER.value -> MeasurementVD.Type.MILLILITER
            else -> MeasurementVD.Type.MILLILITER
        }
    }

}
