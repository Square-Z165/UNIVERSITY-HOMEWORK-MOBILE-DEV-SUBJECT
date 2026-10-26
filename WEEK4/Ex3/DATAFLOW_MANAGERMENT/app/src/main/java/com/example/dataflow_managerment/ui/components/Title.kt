package com.example.dataflow_managerment.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dataflow_managerment.ui.theme.TextGrey

@Composable
fun ContentText(title: String, content: String){
    Text(
        text = title,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
    )
    Spacer(modifier = Modifier.height(10.dp))

    Text(
        text = content,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        textAlign = TextAlign.Center,
        color = TextGrey
    )
    Spacer(modifier = Modifier.height(25.dp))
}