package uk.ac.tees.mad.w9641722.mynewsapp.pages.search

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import uk.ac.tees.mad.w9641722.mynewsapp.api.models.Article
import uk.ac.tees.mad.w9641722.mynewsapp.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val repository: NewsRepository): ViewModel() {

    var newsList by mutableStateOf<List<Article>>(emptyList())
    private var page = 2

    var searchLoading by mutableStateOf(false)

    fun searchNews(searchQuery:String) =
        viewModelScope.launch {
            searchLoading = true
            val response = repository.searchNews(searchQuery)

            newsList = response.data?.articles ?: emptyList()
            searchLoading = false

        }

    var isPaginationLoading by mutableStateOf(false)


    fun searchNextPage(searchQuery:String) =
        viewModelScope.launch {
            isPaginationLoading = true
            val response = repository.searchNews(searchQuery, page = page)
            newsList += response.data?.articles ?: emptyList()
            isPaginationLoading = false
            page++
            Log.d("MainViewModel", "getNextPage: $page")
        }

}