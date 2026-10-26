package com.example.dataflow_managerment.ui.screens

import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dataflow_managerment.ui.components.AppButton
import com.example.dataflow_managerment.ui.components.AppLogo
import com.example.dataflow_managerment.ui.components.AppOutlinedTextField
import com.example.dataflow_managerment.ui.components.BaseScreen
import com.example.dataflow_managerment.ui.components.ContentText
import com.example.dataflow_managerment.viewmodel.AuthViewModel

@Composable
fun ConfirmScreen(
    viewModel: AuthViewModel = viewModel(),
    onBackClick: () -> Unit = {},
    onConfirmClick: () -> Unit = {}
) {
    val userData = viewModel.userData

    BaseScreen(
        showBackButton = true,
        onBackClick = onBackClick
    ) {
        AppLogo()
        ContentText(
            "Confirm",
            "We are here to help you!"
        )
        AppOutlinedTextField(
            state = rememberTextFieldState(userData.email),
            placeholderText = "Email",
            leadingIconVector = Icons.Outlined.Email,
            enabled = false
        )
        AppOutlinedTextField(
            state = rememberTextFieldState(userData.otp),
            placeholderText = "OTP Code",
            leadingIconVector = Icons.Outlined.Lock,
            enabled = false
        )
        AppOutlinedTextField(
            state = rememberTextFieldState(userData.password),
            placeholderText = "New Password",
            leadingIconVector = Icons.Outlined.Lock,
            enabled = false
        )
        AppButton(
            text = "Summit",
            onClick = onConfirmClick
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ConfirmPreview() {
    ConfirmScreen()
}
