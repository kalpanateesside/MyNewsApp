package uk.ac.tees.mad.w9641722.mynewsapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import uk.ac.tees.mad.w9641722.mynewsapp.pages.HomePage
import uk.ac.tees.mad.w9641722.mynewsapp.pages.LoginPage
import uk.ac.tees.mad.w9641722.mynewsapp.pages.SignUpPage

@Composable
fun MyAppNavigation(modifier: Modifier = Modifier, authViewModel: AuthViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login", builder = {
        composable("login"){
            LoginPage(Modifier, navController, authViewModel)
        }
        composable("signup"){
            SignUpPage(Modifier, navController, authViewModel)
        }
        composable("home"){
            HomePage(Modifier, navController, authViewModel)
        }
    } )
}