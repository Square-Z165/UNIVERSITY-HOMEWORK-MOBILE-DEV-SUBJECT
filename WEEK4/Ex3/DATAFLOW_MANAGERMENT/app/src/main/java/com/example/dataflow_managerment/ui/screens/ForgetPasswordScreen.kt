package com.example.dataflow_managerment.ui.screens

import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dataflow_managerment.ui.components.AppButton
import com.example.dataflow_managerment.ui.components.AppLogo
import com.example.dataflow_managerment.ui.components.AppOutlinedTextField
import com.example.dataflow_managerment.ui.components.BaseScreen
import com.example.dataflow_managerment.ui.components.ContentText
import com.example.dataflow_managerment.ui.components.SuccessOverlayDialog
import com.example.dataflow_managerment.viewmodel.AuthViewModel

@Composable
fun FGPScreen(
    viewModel: AuthViewModel = viewModel(),
    showDialog: Boolean = false,
    onDismissDialog: () -> Unit = {},
    onNextClick: () -> Unit = {}
) {
    val emailState = rememberTextFieldState(viewModel.userData.email)

    BaseScreen(
        showBackButton = false
    ) {
        AppLogo()
        ContentText(
            "Forget Password?",
            "Enter your email we will send you a verification code"
        )
        AppOutlinedTextField(
            state = emailState,
            placeholderText = "Your Email",
            leadingIconVector = Icons.Outlined.Email
        )
        AppButton(
            text = "Next",
            onClick = {
                viewModel.updateEmail(emailState.text.toString())
                onNextClick()
            }
        )
    }

    if (showDialog) {
        SuccessOverlayDialog(
            userData = viewModel.userData,
            onDismiss = onDismissDialog
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HHdfkhsad() {
    FGPScreen()
}
