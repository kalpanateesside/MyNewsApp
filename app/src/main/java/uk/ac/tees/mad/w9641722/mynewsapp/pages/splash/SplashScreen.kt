package uk.ac.tees.mad.w9641722.mynewsapp.pages.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import uk.ac.tees.mad.w9641722.mynewsapp.R
import uk.ac.tees.mad.w9641722.mynewsapp.pages.AppGraphs
import uk.ac.tees.mad.w9641722.mynewsapp.pages.AppScreens
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.delay

@Composable
fun SplashScreen (navController: NavHostController) {

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(R.drawable.applogo),
            contentDescription = "App Logo",
            modifier = Modifier.fillMaxSize())
    }


    LaunchedEffect(key1 = true) {
        delay(2500L)

        if (FirebaseAuth.getInstance().currentUser != null) {
            navController.navigate(AppGraphs.Main.name) {
                popUpTo(AppScreens.SplashScreen.name) {
                    inclusive = true
                }
            }
        } else {
            navController.navigate(AppGraphs.Auth.name) {
                popUpTo(AppScreens.SplashScreen.name) {
                    inclusive = true
                }
            }
        }

    }

}