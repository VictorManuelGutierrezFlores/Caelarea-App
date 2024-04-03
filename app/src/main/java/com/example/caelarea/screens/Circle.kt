package com.example.caelarea.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.caelarea.calculateCirArea

@Preview
@Composable
fun Circle() {
    // State variables for radius and area
    var radius by remember { mutableStateOf("") }
    var area by remember { mutableStateOf(0.0) } // Initial area set to 0.0

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        OutlinedTextField(
            value = radius,
            onValueChange = { newRadius ->
                // Validate input immediately on change
                if (newRadius.all { it.isDigit() || it == '.' }) {
                    radius = newRadius
                }
            },
            label = { Text("Radio Círculo") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
        )

        Button(
            onClick = {
                val parsedRadius = radius.toDoubleOrNull()
                if (parsedRadius != null) {
                    area = calculateCirArea(parsedRadius)
                } else {
                    // Handle invalid input (optional)
                    // You could show a toast or snackbar here
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Text(text = "Calcular")
        }

        if (area > 0.0) {
            Text(text = "El área del círculo es: $area")
        }
    }
}
