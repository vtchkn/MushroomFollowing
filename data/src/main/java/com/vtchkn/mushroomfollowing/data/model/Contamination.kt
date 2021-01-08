package com.vtchkn.mushroomfollowing.data.model

data class Contamination(
    val _id: String? = null,
    val name: String? = null,
    val description: String? = null,
    val isConsumed: Boolean? = null,
    val type: Type? = null
) {
    enum class Type {
        BACTERIA,
        MUSHROOM
    }

}
