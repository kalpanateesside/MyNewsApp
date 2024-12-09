package uk.ac.tees.mad.w9641722.mynewsapp.pages.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import uk.ac.tees.mad.w9641722.mynewsapp.pages.BottomNavHost
import uk.ac.tees.mad.w9641722.mynewsapp.pages.BottomNavIcon
import uk.ac.tees.mad.w9641722.mynewsapp.pages.BottomNavigationBar
import uk.ac.tees.mad.w9641722.mynewsapp.pages.AppScreens

@Composable
fun MainScreen(mainNavController:NavHostController) {


    val navItems = listOf(
        BottomNavIcon(
            "Home",
            AppScreens.HomeScreen.name,
            Icons.Default.Home
        )
        ,
        BottomNavIcon(
            "Search",
            AppScreens.SearchScreen.name,
            Icons.Default.Search
        ),
        BottomNavIcon(
            "Saved",
            AppScreens.SavedScreen.name,
            Icons.Default.Favorite
        ),
        BottomNavIcon(
            "Settings",
            AppScreens.SettingScreen.name,
            Icons.Default.Settings
        )
    )

val navController = rememberNavController()
    // This is the inner navController for the search,saved,home,setting screens
    // different navController for different navHosts
    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                navController = navController,
                items = navItems
            )
        }
    ) {
        BottomNavHost(
            mainNavController= mainNavController,
            navController = navController,
            modifier = Modifier.padding(it)
        )
    }
}