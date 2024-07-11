package com.example.mada01

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_secondary)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btn = findViewById<Button>(R.id.secondActBtn)
        btn.setOnClickListener {
            val email = findViewById<TextView>(R.id.editTextTextEmailAddress)
            val inputText = email.text.toString().trim()
            val emailRegex = Regex("^([a-zA-Z0-9_\\-\\\\.]+)@([a-zA-Z0-9_\\-\\\\.]+)\\.([a-zA-Z]{2,5})$")

            if (inputText.isNotEmpty() && emailRegex.matches(inputText)) {
                val resultIntent = Intent()
                resultIntent.putExtra("email", inputText)
                setResult(Activity.RESULT_OK, resultIntent)
                finish()
            }
            else {
                Toast.makeText(this,  "Invalid email address.", Toast.LENGTH_SHORT).show()
            }
        }

    }
}