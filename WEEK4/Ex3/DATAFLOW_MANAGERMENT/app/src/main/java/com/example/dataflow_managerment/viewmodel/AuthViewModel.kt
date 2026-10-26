package com.example.dataflow_managerment.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.dataflow_managerment.data.AuthUserData

class AuthViewModel: ViewModel(){
    var userData by mutableStateOf(AuthUserData())
    //User input email..... yah it work
    fun updateEmail(newEmail: String){
        userData = userData.copy(email = newEmail)
    }
    fun updateOTP(otp: String){
        userData = userData.copy(otp = otp)
    }
    fun updatePassword(password: String){
        userData = userData.copy(password = password)
    }
}