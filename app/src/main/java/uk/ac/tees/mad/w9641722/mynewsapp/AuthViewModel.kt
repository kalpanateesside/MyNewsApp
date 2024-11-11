package uk.ac.tees.mad.w9641722.mynewsapp


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class AuthViewModel : ViewModel() {

    private val auth : FirebaseAuth = FirebaseAuth.getInstance()
    private val _authstate = MutableLiveData<Authstate>()
    val authstate : LiveData<Authstate> = _authstate

    init{
        checkAuthStatus()
    }

    fun checkAuthStatus(){
        if(auth.currentUser==null){
            _authstate.value = Authstate.Unauthenticated
        } else{
            _authstate.value = Authstate.Authenticated
        }
    }

    fun login(email:String, password : String){

        if(email.isEmpty() || password.isEmpty()){
            _authstate.value = Authstate.Error("Email or password cannot be empty;\n)")
            return
        }

        _authstate.value = Authstate.Loading
        auth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener{task->
                if(task.isSuccessful){
                    _authstate.value = Authstate.Authenticated
                } else{
                    _authstate.value = Authstate.Error(
                        task.exception?.message ?: ("\n" +
                                "Oops! Looks like there's an error")
                    )
                }
            }
    }

    fun signup(email:String, password : String){

        if(email.isEmpty() || password.isEmpty()){
            _authstate.value = Authstate.Error("Email or password can't be empty")
            return
        }

        _authstate.value = Authstate.Loading
        auth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener{task->
                if(task.isSuccessful){
                    _authstate.value = Authstate.Authenticated
                } else{
                    _authstate.value = Authstate.Error(task.exception?.message?:"Oops! Looks like there's something wrong")
                }
            }
    }

    fun signout(){
        auth.signOut()
        _authstate.value = Authstate.Unauthenticated
    }
}

sealed class Authstate{
    object Authenticated : Authstate()
    object Unauthenticated : Authstate()
    object Loading : Authstate()
    data class Error(val massage: String): Authstate()
}