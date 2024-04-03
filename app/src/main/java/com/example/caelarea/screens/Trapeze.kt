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
import androidx.compose.ui.unit.dp
import com.example.caelarea.calculateTrapArea

@Composable
fun Trapeze(){
    var minorBase by remember { mutableStateOf("") }
    var majorBase by remember { mutableStateOf("") }
    var height by remember { mutableStateOf("") }
    var area by remember { mutableStateOf(0.0) } // Initial area set to 0.0

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        OutlinedTextField(
            value = minorBase,
            onValueChange = { newminorBase ->
                // Validate input immediately on change
                if (newminorBase.all { it.isDigit() || it == '.' })
                {
                    minorBase = newminorBase
                }
            },
            label = { Text("Base Menor") },
            modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = majorBase,
            onValueChange = { newmajorBase ->
                // Validate input immediately on change
                if (newmajorBase.all { it.isDigit() || it == '.' })
                {
                    majorBase = newmajorBase
                }
            },
            label = { Text("Base Mayor") },
            modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
        )

        OutlinedTextField(
            value = height,
            onValueChange = { newHeight ->
                // Validate input immediately on change
                if (newHeight.all { it.isDigit() || it == '.' })
                {
                    height = newHeight
                }
            },
            label = { Text("Altura") },
            modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
        )

        Button(
            onClick = {
                val parsedMinorBase = minorBase.toDoubleOrNull()
                val parsedMajorBase = majorBase.toDoubleOrNull()
                val parsedHeight = height.toDoubleOrNull()
                if (parsedMinorBase != null && parsedMajorBase != null && parsedHeight != null)
                {
                    area = calculateTrapArea(parsedHeight, parsedMinorBase, parsedMajorBase)
                } else
                {
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

        if (area > 0.0)
        {
            Text(text = "El area del trapecio es: $area")
        }

    }
}