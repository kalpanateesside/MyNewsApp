package uk.ac.tees.mad.w9641722.mynewsapp.api.models

data class Source(
    val id: String?,
    val name: String?
){
    constructor() : this(
    null,
    null
    )
}