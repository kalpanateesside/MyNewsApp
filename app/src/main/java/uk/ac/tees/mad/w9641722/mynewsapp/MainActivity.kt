package uk.ac.tees.mad.w9641722.mynewsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import uk.ac.tees.mad.w9641722.mynewsapp.pages.AppGraphs
import uk.ac.tees.mad.w9641722.mynewsapp.pages.AppScreens
import uk.ac.tees.mad.w9641722.mynewsapp.pages.auth.CreateAccountScreen
import uk.ac.tees.mad.w9641722.mynewsapp.pages.auth.LogInScreen
import uk.ac.tees.mad.w9641722.mynewsapp.pages.main.MainScreen
import uk.ac.tees.mad.w9641722.mynewsapp.pages.splash.SplashScreen
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint
import uk.ac.tees.mad.w9641722.mynewsapp.ui.theme.MyNewsApp

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyNewsApp {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    TransparentSystemBars()

                    AppNavigation()
                }
            }
        }
    }

}

@Composable
fun TransparentSystemBars() {
    val systemUiController = rememberSystemUiController()
    val useDarkIcons = !isSystemInDarkTheme()
    val isDarkTheme = isSystemInDarkTheme()
    SideEffect {
        if (isDarkTheme) {
            systemUiController.setSystemBarsColor(
                color = Color.Black,
                darkIcons = useDarkIcons
            )
        } else {
            systemUiController.setSystemBarsColor(
                color = Color.Transparent,
                darkIcons = useDarkIcons
            )
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.SplashScreen.name) {
        composable(AppScreens.SplashScreen.name) {
            SplashScreen(navController = navController)
        }
        navigation(startDestination = AppScreens.LogInScreen.name, route = AppGraphs.Auth.name) {
            composable(AppScreens.LogInScreen.name) {
                LogInScreen(navController = navController)
            }
            composable(AppScreens.CreateAccountScreen.name) {
                CreateAccountScreen(navController = navController)
            }
        }
        navigation(startDestination = AppScreens.MainScreen.name, route = AppGraphs.Main.name) {
            composable(AppScreens.MainScreen.name) {
                MainScreen(mainNavController = navController)
            }
        }
    }
}
