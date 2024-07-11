package com.example.mada01

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {

    val EMAIL_INP_REQ: Int  = 101;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btn = findViewById<Button>(R.id.btnMain)
        btn.setOnClickListener {
            val intent = Intent(this, SecondaryActivity::class.java)
            startActivityForResult(intent, EMAIL_INP_REQ)
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == EMAIL_INP_REQ) {
            if (resultCode == Activity.RESULT_OK) {
                if (data != null) {
                    val receivedData = data.getStringExtra("email")
                    Toast.makeText(this,  receivedData, Toast.LENGTH_SHORT).show()

                }
            }
        }
    }
}