package uk.ac.tees.mad.w9641722.mynewsapp.pages.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import uk.ac.tees.mad.w9641722.mynewsapp.api.DataOrException
import uk.ac.tees.mad.w9641722.mynewsapp.api.models.Article
import uk.ac.tees.mad.w9641722.mynewsapp.api.models.NewsResponse
import uk.ac.tees.mad.w9641722.mynewsapp.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: NewsRepository) : ViewModel() {

    var page = 2

    var result: MutableStateFlow<DataOrException<NewsResponse, Boolean, Exception>> =
        MutableStateFlow(
            DataOrException(
                NewsResponse(emptyList(), "", -1),
                true,
                null
            )
        )
    val list = mutableStateOf<List<Article>>(emptyList())

    init {
        getNews()
    }

    var isPaginationLoading by mutableStateOf(false)

    fun getNews() =
        viewModelScope.launch {
            result.emit(DataOrException(result.value.data, true, null))
            val response = repository.getNews()
            list.value = response.data?.articles ?: emptyList()
            result.emit(response)
        }

    fun getNextPage() =
        viewModelScope.launch {
            isPaginationLoading = true
            val newResponse = repository.getNews(page = page)
            list.value += newResponse.data?.articles ?: emptyList()
            isPaginationLoading = false
            page++
        }


}