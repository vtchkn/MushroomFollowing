package com.vtchkn.mushroomfollowing.viewdata

data class ContaminationVD(
    val _id: String? = null,
    val name: String? = null,
    val description: String? = null,
    val isConsumed: Boolean? = null,
    val type: Type? = null
) {

    enum class Type(val value: String) {
        BACTERIA("bacteria"),
        MUSHROOM("mushroom")
    }

}
