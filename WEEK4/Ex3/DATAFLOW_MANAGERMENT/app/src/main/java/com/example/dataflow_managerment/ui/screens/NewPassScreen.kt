package com.example.dataflow_managerment.ui.screens

import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dataflow_managerment.ui.components.AppButton
import com.example.dataflow_managerment.ui.components.AppLogo
import com.example.dataflow_managerment.ui.components.AppOutlinedTextField
import com.example.dataflow_managerment.ui.components.BaseScreen
import com.example.dataflow_managerment.ui.components.ContentText
import com.example.dataflow_managerment.ui.theme.BlueDefaut
import com.example.dataflow_managerment.ui.theme.TextGrey
import com.example.dataflow_managerment.viewmodel.AuthViewModel

@Composable
fun NewPassWordScreen(
    viewModel: AuthViewModel = viewModel(),
    onBackClick: () -> Unit = {},
    onNextClick: () -> Unit = {}
) {
    val passwordState = rememberTextFieldState(viewModel.userData.password)
    val confirmPasswordState = rememberTextFieldState()

    val passText = passwordState.text.toString()
    val confirmText = confirmPasswordState.text.toString()

    val isNotEmpty = passText.isNotBlank() && confirmText.isNotBlank()
    val passwordsMatch = passText == confirmText
    val isError = isNotEmpty && !passwordsMatch
    val isEnabled = isNotEmpty && passwordsMatch

    val buttonColor = if (isEnabled) BlueDefaut else TextGrey

    BaseScreen(
        showBackButton = true,
        onBackClick = onBackClick
    ) {
        AppLogo()
        ContentText(
            "Create New Password",
            "Your new password must be different from previous used password"
        )
        AppOutlinedTextField(
            state = passwordState,
            placeholderText = "Password",
            leadingIconVector = Icons.Outlined.Lock
        )
        AppOutlinedTextField(
            state = confirmPasswordState,
            placeholderText = "Confirm Password",
            leadingIconVector = Icons.Outlined.Lock,
            isError = isError
        )
        AppButton(
            text = "Next",
            enabled = isEnabled,
            containerColor = buttonColor,
            onClick = {
                viewModel.updatePassword(passText)
                onNextClick()
            }
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ShowMe() {
    NewPassWordScreen()
}
