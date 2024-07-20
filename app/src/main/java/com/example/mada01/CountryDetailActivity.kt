package com.example.mada01

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CountryDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_country_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.countryDetail)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val c = intent.getParcelableExtra<Country>("country")
        findViewById<TextView>(R.id.countryDetailName).text = c?.name
        findViewById<TextView>(R.id.countryDetailCapital).text = c?.capital
        findViewById<TextView>(R.id.countryDetailPopulation).text = c?.population.toString()
        findViewById<ImageView>(R.id.dtlFlagImage).setImageResource(c?.flagResourceId ?: 0)

    }
}