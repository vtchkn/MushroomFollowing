package com.vtchkn.mushroomfollowing.api.mappers

import com.vtchkn.mushroomfollowing.api.model.Flush
import com.vtchkn.mushroomfollowing.base.Mapper
import com.vtchkn.mushroomfollowing.viewdata.FlushVD

class FlushVDMapper(private val productionResultVDMapper: ProductionResultVDMapper) :
    Mapper<FlushVD?, Flush?>() {
    override fun executeMapping(type: Flush?): FlushVD? {
        return type?.run {
            FlushVD(
                _id = _id,
                index = index,
                description = description,
                productionResult = productionResultVDMapper.executeMapping(productionResult)
            )
        }
    }

}
