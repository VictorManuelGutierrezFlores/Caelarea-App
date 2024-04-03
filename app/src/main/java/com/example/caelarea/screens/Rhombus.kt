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
import com.example.caelarea.calculateRomArea

@Preview
@Composable
fun Rhombus()
{
    var minorDiagonal by remember { mutableStateOf("") }
    var majorDiagonal by remember { mutableStateOf("") }
    var area by remember { mutableStateOf(0.0) } // Initial area set to 0.0

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        OutlinedTextField(
            value = majorDiagonal,
            onValueChange = { newmajorDiagonal ->
                // Validate input immediately on change
                if ( newmajorDiagonal.all { it.isDigit() || it == '.' })
                {
                    majorDiagonal = newmajorDiagonal
                }
            },
            label = { Text("Diagonal mayor") },
            modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = minorDiagonal,
            onValueChange = { newminorDiagonal ->
                // Validate input immediately on change
                if (newminorDiagonal.all { it.isDigit() || it == '.' })
                {
                    minorDiagonal = newminorDiagonal
                }
            },
            label = { Text("Diagonal menor") },
            modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
        )


        Button(
            onClick = {
                val parsedMinorDiagonal = minorDiagonal.toDoubleOrNull()
                val parsedMajorDiagonal = majorDiagonal.toDoubleOrNull()
                if (parsedMinorDiagonal != null && parsedMajorDiagonal != null)
                {
                    area = calculateRomArea(parsedMajorDiagonal, parsedMinorDiagonal)
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
            Text(text = "El area del rombo: $area")
        }

    }
}