package uk.ac.tees.mad.w9641722.mynewsapp.repository

import uk.ac.tees.mad.w9641722.mynewsapp.api.DataOrException
import uk.ac.tees.mad.w9641722.mynewsapp.api.models.NewsResponse
import uk.ac.tees.mad.w9641722.mynewsapp.api.NewsApi
import javax.inject.Inject

class NewsRepository @Inject constructor(private val api: NewsApi) {

    suspend fun getNews(
        page:Int = 1
    ): DataOrException<NewsResponse, Boolean, Exception> {
        val response = try {
             api.getNews(page = page)

        }catch (e:Exception){
            return DataOrException(loading = false,exception = e)
        }
        return DataOrException(response,false)

    }

    suspend fun searchNews(searchQuery:String,page: Int = 1): DataOrException<NewsResponse, Boolean, Exception> {
        val response = try {
            api.searchNews(searchQuery = searchQuery, page = page)

        }catch (e:Exception){
            return DataOrException(loading = false,exception = e)
        }
        return DataOrException(response,false)

    }


}