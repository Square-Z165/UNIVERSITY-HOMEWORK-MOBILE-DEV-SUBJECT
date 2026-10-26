package com.example.dataflow_managerment.ui.screens

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dataflow_managerment.ui.components.AppButton
import com.example.dataflow_managerment.ui.components.AppLogo
import com.example.dataflow_managerment.ui.components.BaseScreen
import com.example.dataflow_managerment.ui.components.ContentText
import com.example.dataflow_managerment.ui.components.OTPTextField
import com.example.dataflow_managerment.viewmodel.AuthViewModel

@Composable
fun VerifyScreen(
    viewModel: AuthViewModel = viewModel(),
    onBackClick: () -> Unit = {},
    onNextClick: () -> Unit = {}
) {
    var otpValue by remember { mutableStateOf(viewModel.userData.otp) }

    BaseScreen(
        showBackButton = true,
        onBackClick = onBackClick
    ) {
        AppLogo()
        ContentText(
            "Verify Code",
            "Enter the code, we just send you on your registered email"
        )
        OTPTextField(
            otpText = otpValue,
            onOtpTextChange = { value, _ ->
                otpValue = value
            },
            length = 5
        )
        Spacer(modifier = Modifier.height(25.dp))
        AppButton(
            text = "Next",
            onClick = {
                viewModel.updateOTP(otpValue)
                onNextClick()
            }
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun VSP() {
    VerifyScreen()
}
