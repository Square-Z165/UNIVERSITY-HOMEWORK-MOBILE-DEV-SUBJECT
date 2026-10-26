package com.example.dataflow_managerment.data

data class AuthUserData(
    var email: String = "",
    var password: String = "",
    var otp: String = ""
) {
    fun isEmailValid(): Boolean {
        val pattern = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}"
        return email.matches(pattern.toRegex())
    }
}
