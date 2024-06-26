package com.example.caelarea.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.caelarea.R
import com.example.caelarea.calculateTrianArea

@Preview
@Composable
fun Triangle(){
    /// INIT VARIABLE
    var base by remember { mutableStateOf("") }
    var height by remember { mutableStateOf("") }
    var area by remember { mutableStateOf(0.0) } // Initial area set to 0.0


    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.triangule_image), contentDescription = null )
        Text(text = "Triangulo")

        OutlinedTextField(
            value = base,
            onValueChange = { newBase ->
                // Validate input immediately on change
                if (newBase.all { it.isDigit() || it == '.' })
                {
                    base = newBase
                }
            },
            label = { Text("Base") },
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
                val parsedBase = base.toDoubleOrNull()
                val parsedHeight = height.toDoubleOrNull()
                if (parsedBase != null && parsedHeight != null )
                {
                    area = calculateTrianArea(parsedHeight, parsedBase)
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
            Text(text = "El area del triangulo es: $area")
        }

    }
}