package com.example.dataflow_managerment.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Android
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.dataflow_managerment.ui.theme.BlueDefaut
import com.example.dataflow_managerment.ui.theme.ErRED
import com.example.dataflow_managerment.ui.theme.TextGrey

@Composable
fun AppOutlinedTextField(
    state: TextFieldState = rememberTextFieldState(),
    placeholderText: String = "Your Email",
    leadingIconVector: ImageVector = Icons.Outlined.Android,
    enabled: Boolean = true,
    isError: Boolean = false
) {
    OutlinedTextField(
        state = state,
        enabled = enabled,
        isError = isError,
        leadingIcon = {
            Icon(
                imageVector = leadingIconVector,
                contentDescription = "Icon",
                tint = TextGrey
            )
        },
        placeholder = {
            Text(
                text = placeholderText, color = TextGrey
            )
        },
        lineLimits = TextFieldLineLimits.SingleLine,
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier.fillMaxWidth(),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = BlueDefaut,
            unfocusedBorderColor = TextGrey,
            errorBorderColor = ErRED
        )
    )
    Spacer(modifier = Modifier.height(25.dp))
}
