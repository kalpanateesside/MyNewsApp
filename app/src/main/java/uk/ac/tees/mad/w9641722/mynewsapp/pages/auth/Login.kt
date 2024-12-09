package uk.ac.tees.mad.w9641722.mynewsapp.pages.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import uk.ac.tees.mad.w9641722.mynewsapp.pages.AppGraphs
import uk.ac.tees.mad.w9641722.mynewsapp.pages.AppScreens
import uk.ac.tees.mad.w9641722.mynewsapp.R

@Composable
fun LogInScreen(
    navController: NavHostController,
    authViewModel: AuthViewModel = hiltViewModel()
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(
                rememberScrollState()
            )
    ) {
        Image(
            painter = painterResource(R.drawable.applogo),
            contentDescription = "App Logo",
            modifier =  Modifier.height(40.dp).fillMaxWidth())
        Spacer(modifier = Modifier.height(20.dp))
        Icon(Icons.Default.Lock,"null",modifier = Modifier.size(50.dp))
        Spacer(modifier = Modifier.height(20.dp))
        Text("Sign In", modifier = Modifier.padding(4.dp), fontSize = 25.sp)

        val context = LocalContext.current
        UserForm(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            buttonText = "Sign In",
            onButtonClick = { email, password ->
                authViewModel.signInWithEmailAndPassword(email,password){
                    navController.navigate(AppGraphs.Main.name){
                        popUpTo(AppGraphs.Auth.name){
                            inclusive = true
                        }
                    }

                }
            },
            newUserText = "Don't have an account? ",
            signUpText = "Sign Up",
            signUpTextOnClick = {
                navController.navigate(AppScreens.CreateAccountScreen.name)
            }
        )
    }
}