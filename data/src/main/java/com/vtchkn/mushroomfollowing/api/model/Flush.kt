package com.vtchkn.mushroomfollowing.api.model

import com.vtchkn.mushroomfollowing.repository.model.ProductionResult

data class Flush(
    val _id: String? = null,
    val index: Int? = null,
    val description: String? = null,
    val productionResult: ProductionResult? = null
) {

}
