package com.example.dataflow_managerment.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.dataflow_managerment.data.AuthUserData
import com.example.dataflow_managerment.ui.theme.BlueDefaut

@Composable
fun SuccessOverlayDialog(
    userData: AuthUserData,
    onDismiss: () -> Unit
) {
    Dialog(onDismissRequest = onDismiss) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Success!",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = BlueDefaut
                )
                Spacer(modifier = Modifier.height(16.dp))

                Text(text = "Email: ${userData.email}")
                Text(text = "OTP: ${userData.otp}")
                Text(text = "Password: ${userData.password}")

                Spacer(modifier = Modifier.height(20.dp))

                AppButton(
                    text = "OK",
                    containerColor = BlueDefaut,
                    onClick = onDismiss
                )
            }
        }
    }
}
