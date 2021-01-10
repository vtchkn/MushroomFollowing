package com.vtchkn.mushroomfollowing.api.mappers

import com.vtchkn.mushroomfollowing.api.model.Race
import com.vtchkn.mushroomfollowing.api.model.Size
import com.vtchkn.mushroomfollowing.base.Mapper
import com.vtchkn.mushroomfollowing.viewdata.RaceVD
import com.vtchkn.mushroomfollowing.viewdata.SizeVD

class SizeVDMapper(private val measurementVDMapper: MeasurementVDMapper) :
    Mapper<SizeVD?, Size?>() {
    override fun executeMapping(type: Size?): SizeVD? {
        return type?.run {
           SizeVD(
               _id = _id,
               value = value,
               measurementVD = measurementVDMapper.executeMapping(measurement)
           )
        }
    }

}
