package com.vtchkn.mushroomfollowing.viewdata

data class SizeVD(
    val _id: String? = null,
    val value: Int? = null,
    val measurementVD: MeasurementVD? = null
) {

    val textString: String = "$value ${measurementVD?.name}"
}
