package com.vtchkn.mushroomfollowing.viewdata

data class MeasurementVD(
    val name: String? = null,
    val type: Type? = null,
) {

    enum class Type(val value: String) {
        GRAM("gram"),
        MILLILITER("milliliter")
    }

}