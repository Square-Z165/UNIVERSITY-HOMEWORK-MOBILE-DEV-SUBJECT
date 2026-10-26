package com.example.dataflow_managerment.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dataflow_managerment.ui.theme.BlueDefaut
import com.example.dataflow_managerment.ui.theme.TextGrey

@Composable
fun OTPTextField(
    modifier: Modifier = Modifier,
    otpText: String,
    onOtpTextChange: (String, Boolean) -> Unit,
    length: Int = 5
) {
    BasicTextField(
        modifier = modifier,
        value = TextFieldValue(otpText, selection = TextRange(otpText.length)),
        onValueChange = { 
            if (it.text.length <= length && it.text.all { char -> char.isDigit() }) {
                onOtpTextChange(it.text, it.text.length == length)
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        decorationBox = {
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                repeat(length) { index ->
                    val char = when {
                        index < otpText.length -> otpText[index].toString()
                        else -> ""
                    }
                    
                    /*Focus or Inputted logic */
                    val hasChar = index < otpText.length
                    val isFocused = index == otpText.length
                    val borderColor = if (hasChar || isFocused) BlueDefaut else TextGrey
                    val borderWidth = if (hasChar || isFocused) 2.dp else 1.dp

                    Box(
                        modifier = Modifier
                            .size(55.dp)
                            .background(
                                color = Color.Transparent, // Nền trong suốt kiểu Outline
                                shape = RoundedCornerShape(12.dp)
                            )
                            .border(
                                width = borderWidth,
                                color = borderColor,
                                shape = RoundedCornerShape(12.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = char,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    )
}
