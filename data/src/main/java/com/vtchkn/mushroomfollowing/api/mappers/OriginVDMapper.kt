package com.vtchkn.mushroomfollowing.api.mappers

import com.vtchkn.mushroomfollowing.base.Mapper
import com.vtchkn.mushroomfollowing.repository.model.Origin
import com.vtchkn.mushroomfollowing.viewdata.OriginVD
import com.vtchkn.mushroomfollowing.viewdata.parseTimeStamp

class OriginVDMapper(private val sizeVDMapper: SizeVDMapper) :
    Mapper<OriginVD?, Origin?>() {
    override fun executeMapping(type: Origin?): OriginVD? {
        return type?.run {
            OriginVD(
                _id = _id,
                name = name,
                description = description,
                creationDate = creationDate?.parseTimeStamp(),
                possibilityOfContamination = possibilityOfContamination,
                size = sizeVDMapper.executeMapping(size)
            )
        }
    }

}
