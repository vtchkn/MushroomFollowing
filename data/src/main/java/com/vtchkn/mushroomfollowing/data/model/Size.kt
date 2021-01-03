package com.vtchkn.mushroomfollowing.repository.model

data class Size(
    val _id: String? = null,
    val value: Int? = null,
    val measurements: Measurements
) {
    enum class Measurements {
        GRAM,
        MILLILITER
    }

}
