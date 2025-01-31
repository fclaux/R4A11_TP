package com.example.tp2

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Calendar

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val intent = intent
            val name = intent.getStringExtra("name")
            val birthYear = intent.getIntExtra("birth", 0)
            val age = ageCalculator(birthYear)
            val text = "Hello $name, vous avez $age ${if (age in -1..1) "an" else "ans"} !"
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Text(
                    text = text,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier
                        .wrapContentWidth()
                        .align(Alignment.CenterHorizontally)
                        .weight(1f)
                        .wrapContentHeight(Alignment.CenterVertically)
                )

                Button(
                    onClick = {
                        val mainActivityIntent  = Intent(this@MainActivity2, MainActivity::class.java)
                        startActivity(mainActivityIntent)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp)
                ) {
                    Text("Retour en arrière")
                }
            }
        }
    }
}

fun ageCalculator(birthYear: Int): Int {
    val currentYear = Calendar.getInstance().get(Calendar.YEAR)
    return currentYear - birthYear
}

