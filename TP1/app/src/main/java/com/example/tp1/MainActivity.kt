package com.example.tp1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val EXTRA_TEXT = "text_to_display"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val rootView = findViewById<ConstraintLayout>(R.id.main)
        rootView.setBackgroundResource(R.drawable.gradient_background)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val premierBouton : Button = findViewById(R.id.premierButton);
        val textInput : EditText = findViewById(R.id.editTextText);
        val textView : TextView = findViewById(R.id.textView);

        val bouttonPageSuivante : Button = findViewById(R.id.buttonNextPage);

        bouttonPageSuivante.setOnClickListener {
            val intent = Intent(this@MainActivity, MainActivity2::class.java)
            intent.putExtra(EXTRA_TEXT, textView.text.toString())
            startActivity(intent);
        }


        premierBouton.setOnClickListener {
            if (textInput.text.toString() == "afficher nouveau textView") {
                val layoutPrincipal : ConstraintLayout = findViewById(R.id.main);
                val newTextView : TextView = TextView(this);
                newTextView.text = textInput.text;
                layoutPrincipal.addView(newTextView);
            }


            textView.text = textInput.text;
        }
    }
}