package uk.ac.tees.mad.w9641722.mynewsapp.api.models

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)