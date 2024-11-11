package uk.ac.tees.mad.w9641722.mynewsapp.pages

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import uk.ac.tees.mad.w9641722.mynewsapp.AuthViewModel
import uk.ac.tees.mad.w9641722.mynewsapp.Authstate

@Composable
fun SignUpPage(modifier: Modifier = Modifier, navController: NavController, authViewModel: AuthViewModel) {
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }

    val authstate = authViewModel.authstate.observeAsState()
    val context = LocalContext.current
    
    LaunchedEffect(authstate.value) {
        when(authstate.value){
            is Authstate.Authenticated -> navController.navigate("home")
            is Authstate.Error ->  Toast.makeText(context,
                (authstate.value as Authstate.Error).massage,Toast.LENGTH_SHORT).show()
            else -> Unit
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Sign Up Page", fontSize = 32.sp)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value= email,
            onValueChange={
                email= it},
            label ={
                Text(text = "Email")
            }
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value= password,
            onValueChange={
                password= it},
            label ={
                Text(text = "Password")
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {authViewModel.signup(email, password)},
            enabled = authstate.value != Authstate.Loading)
        {
            Text(text = "create an account")
        }
        Spacer(modifier = Modifier.height(16.dp))
        TextButton(
            onClick = {
                navController.navigate("login")
            })
        {
            Text(text = "New Account?")
        }

    }
}