package com.example.dataflow_managerment.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dataflow_managerment.R
import com.example.dataflow_managerment.ui.theme.BlueDefaut

@Composable
fun AppLogo() {
    Image(
        modifier = Modifier.size(100.dp),
        painter = painterResource(id = R.drawable.uth_logo),
        contentDescription = "UTHLogo"
    )
    Spacer(modifier = Modifier.height(16.dp))

    Text(
        text = "SmartTask",
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp,
        color = BlueDefaut
    )
    Spacer(modifier = Modifier.height(25.dp))
}
