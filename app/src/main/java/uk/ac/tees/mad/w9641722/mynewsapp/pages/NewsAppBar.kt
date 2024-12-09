package uk.ac.tees.mad.w9641722.mynewsapp.pages

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsAppBar(
    title:String,
    isMainScreen: Boolean,
    navController:NavHostController,
    modifier: Modifier = Modifier

) {
    CenterAlignedTopAppBar(
        title = {
                Text(title)
        },
        navigationIcon = {
            if(!isMainScreen){
                IconButton(onClick = { navController.navigateUp()}) {
                    Icon(Icons.Default.ArrowBack,"Go Back")
                }
            }
        },
        modifier = modifier

    )
}
