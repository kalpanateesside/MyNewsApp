package uk.ac.tees.mad.w9641722.mynewsapp.pages.saved

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import uk.ac.tees.mad.w9641722.mynewsapp.pages.NewsAppBar
import uk.ac.tees.mad.w9641722.mynewsapp.pages.newsrow.NewsRow

@Composable
fun SavedScreen(navController: NavHostController,savedViewModel: SavedViewModel = hiltViewModel()) {
    Scaffold(
        topBar = {

            Surface(shadowElevation = 1.dp) {

                NewsAppBar(
                    title = "Saved Articles",
                    isMainScreen = false,
                    navController = navController
                )
            }
        }
    ) {

        savedViewModel.getNewsInRealTime()
        val savedNewsList = savedViewModel.savedNewsList

        Log.d("SavedScreen", "savedNewsList size: ${savedNewsList.value.size} ")

        if (savedNewsList.value.isEmpty()) {
            Box(Modifier.fillMaxSize()) {
                Text("No Saved Articles found")
            }
        } else {
            LazyColumn(Modifier.padding(it)) {
                items(savedNewsList.value){ article->
                    NewsRow(newsArticle = article)
                }


            }
        }
    }

}

