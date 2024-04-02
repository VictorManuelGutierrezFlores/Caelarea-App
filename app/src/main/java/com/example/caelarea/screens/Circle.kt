package com.example.caelarea.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.caelarea.R

@Preview
@Composable
fun Circle(){
    var largo by remember { mutableStateOf("0") }
    var ancho by remember { mutableStateOf("0") }

    Column(
        Modifier.fillMaxWidth()
    ){
        OutlinedTextField(
            value = ancho,
            onValueChange = { ancho = it },
            label = { Text("Ancho") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
        )

        OutlinedTextField(
            value = largo,
            onValueChange = { largo = it },
            label = { Text("Largo") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),

            )

        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Text(text = "Calcular")
        }

        Text(text = "El area del Circulo es: ")
    }

}

