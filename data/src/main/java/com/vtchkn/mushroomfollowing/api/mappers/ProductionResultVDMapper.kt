package com.vtchkn.mushroomfollowing.api.mappers

import com.vtchkn.mushroomfollowing.base.Mapper
import com.vtchkn.mushroomfollowing.repository.model.ProductionResult
import com.vtchkn.mushroomfollowing.viewdata.ProductionResultVD

class ProductionResultVDMapper(private val sizeVDMapper: SizeVDMapper) :
    Mapper<ProductionResultVD, ProductionResult>() {

    override fun executeMapping(type: ProductionResult?): ProductionResultVD? {
        return type?.run {
            ProductionResultVD(_id, sizeVDMapper.executeMapping(size), description)
        }
    }

}
