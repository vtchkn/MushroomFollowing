package com.vtchkn.mushroomfollowing.repository.model

import com.vtchkn.mushroomfollowing.data.model.Date
import com.vtchkn.mushroomfollowing.data.model.Size

/**
 * could be a base, grain, vermiculite, coco fiber etc
 * this could be editable in future for users
 */
data class Substrate(
    val _id: String? = null,
    val name: String? = null,
    val description: String? = null,
    val size: Size? = null,
    val creationDate: Long? = null
) {

}
