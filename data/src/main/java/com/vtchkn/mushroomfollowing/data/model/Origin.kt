package com.vtchkn.mushroomfollowing.repository.model

import com.vtchkn.mushroomfollowing.data.model.Date
import com.vtchkn.mushroomfollowing.data.model.Size

/**
 * lq, petri cup, spores, vial spores, single grain.. etc
 * this could be editable in future for users
 */
data class Origin(
    val _id: String? = null,
    val name: String? = null,
    val description: String? = null,
    val creationDate: Long? = null,
    val possibilityOfContamination: Boolean? = null,
    val size: Size? = null
) {

}

