package com.vtchkn.mushroomfollowing.api.mappers

import com.vtchkn.mushroomfollowing.api.model.Additive
import com.vtchkn.mushroomfollowing.base.Mapper
import com.vtchkn.mushroomfollowing.viewdata.AdditiveVD
import com.vtchkn.mushroomfollowing.viewdata.parseTimeStamp

class AdditiveVDMapper(private val sizeVDMapper: SizeVDMapper) : Mapper<AdditiveVD?, Additive?>() {
    override fun executeMapping(type: Additive?): AdditiveVD? {
        return type?.run { AdditiveVD(
            _id = _id,
            name = name,
            description = description,
            sizeVD = sizeVDMapper.executeMapping(size),
            creationDate = creationDate?.parseTimeStamp()
        ) }
    }

}
