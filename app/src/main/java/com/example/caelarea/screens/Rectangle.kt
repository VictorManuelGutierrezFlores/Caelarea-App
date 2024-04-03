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
import com.example.caelarea.calculateRectArea

@Preview
@Composable
fun Rectangle(){
    // INIT VARIABLES
    var large by remember { mutableStateOf("") }
    var width by remember { mutableStateOf("") }
    var area by remember { mutableStateOf(0.0) }

    Column {
        OutlinedTextField(
            value = large,
            onValueChange = { newLarge ->
                // Validate input immediately on change
                if ( newLarge.all { it.isDigit() || it == '.' })
                {
                    large = newLarge
                }
            },
            label = { Text("Largo") },
            modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = width,
            onValueChange = { newWidth ->
                // Validate input immediately on change
                if ( newWidth.all { it.isDigit() || it == '.' })
                {
                    width = newWidth
                }
            },
            label = { Text("Ancho") },
            modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
        )
        Button(
            onClick = {
                val parsedLarge = large.toDoubleOrNull()
                val parsedWidth = width.toDoubleOrNull()
                if (parsedWidth != null && parsedLarge != null)
                {
                    area = calculateRectArea(parsedWidth, parsedWidth)
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
        
        if( area > 0.0){
            Text(text = "El area del rectangulo es $area")
        }
    }
}