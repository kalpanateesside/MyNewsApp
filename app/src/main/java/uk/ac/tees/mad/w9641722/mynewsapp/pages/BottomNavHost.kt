package uk.ac.tees.mad.w9641722.mynewsapp.pages

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import uk.ac.tees.mad.w9641722.mynewsapp.pages.home.HomeScreen
import uk.ac.tees.mad.w9641722.mynewsapp.pages.saved.SavedScreen
import uk.ac.tees.mad.w9641722.mynewsapp.pages.search.SearchScreen
import uk.ac.tees.mad.w9641722.mynewsapp.pages.setting.SettingScreen


@Composable
fun BottomNavHost(
    mainNavController:NavHostController,
    navController: NavHostController,
    modifier: Modifier = Modifier
) {


    NavHost(
        navController = navController,
        startDestination = AppScreens.HomeScreen.name,
        modifier = modifier
    ) {

        composable(AppScreens.HomeScreen.name) {
            HomeScreen(navController = navController)
        }
        composable(AppScreens.SavedScreen.name) {
            SavedScreen(navController)
        }
        composable(AppScreens.SettingScreen.name) {
            SettingScreen(navController=navController, mainNavController = mainNavController)
        }
        composable(AppScreens.SearchScreen.name) {
            SearchScreen(navController= navController)
        }
    }
}