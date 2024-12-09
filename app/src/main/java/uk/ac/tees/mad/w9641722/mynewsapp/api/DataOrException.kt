package uk.ac.tees.mad.w9641722.mynewsapp.api

class DataOrException<T,Boolean,Exception>(
    val data:T? = null,
    var loading:Boolean? = null,
    val exception: Exception? = null
)
