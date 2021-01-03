package com.vtchkn.mushroomfollowing.repository.model

/**
 * this is basically what you are adding to a substrate or base to prevent contamination,
 * such as antibiotics, gypsum, lime, chalk, etc
 * but maybe you'd like to create your own, so this why I've added a creation data
 * this will be enabled to for users adding their own variants by
 */
data class Additive(
    val _id: String? = null,
    val name: String? = null,
    val description: String? = null,
    val size: Size? = null,
    val creationDate: Date? = null) {

}
