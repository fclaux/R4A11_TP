package com.example.tp2

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

const val NAME_TEXT = "name"
const val BIRTH_YEAR_TEXT = "birth"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var name by remember { mutableStateOf("") }
            var birthYear by remember { mutableStateOf("") }

            Box(modifier = Modifier.fillMaxSize()) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(200.dp))

                    Text(
                        text = "Bienvenue",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(200.dp))

                    TextField(
                        value = name,
                        onValueChange = { name = it },
                        label = { Text("Saisir votre nom") }
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    TextField(
                        value = birthYear,
                        onValueChange = { birthYear = it },
                        label = { Text("Année de naissance") },
                        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Button(onClick = {
                        val birthYearInt = birthYear.toIntOrNull()
                        if (name.isBlank()) {
                            Toast.makeText(this@MainActivity, "Erreur : Veuillez rentrer un nom", Toast.LENGTH_SHORT).show()
                            return@Button
                        }
                        if (birthYearInt == null) {
                            Toast.makeText(this@MainActivity, "Erreur : l'année de naissance n'est pas valide", Toast.LENGTH_SHORT).show()
                            return@Button
                        }

                        val intent = Intent(this@MainActivity, MainActivity2::class.java)
                        intent.putExtra(NAME_TEXT, name.trim())
                        intent.putExtra(BIRTH_YEAR_TEXT, birthYearInt)
                        startActivity(intent)
                    }) {
                        Text("Valider")
                    }
                }
            }
        }
    }
}
