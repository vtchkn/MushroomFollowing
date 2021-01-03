package com.vtchkn.mushroomfollowing.repository.model

/**
 * lq, petri cup, spores, vial spores, single grain.. etc
 * this could be editable in future for users
 */
data class Origin(
    val _id: String? = null,
    val name: String? = null,
    val description: String? = null,
    val creationDate: Date? = null,
    val possibilityOfContamination: Boolean? = null,
    val size: Size? = null
) {

}

