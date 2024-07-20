package com.example.mada01

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Orientation


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val countries  = arrayOf(
            Country(1, "Austria", R.drawable.flag_austria, "Vienna", 8725931),
            Country(2, "Bahrain", R.drawable.flag_bahrain, "Manama", 1404900),
            Country(3, "Belgium", R.drawable.flag_belgium, "Brussels", 11319511),
            Country(4, "Brazil", R.drawable.flag_brazil, "Brasília", 206135893),
            Country(5, "Denmark", R.drawable.flag_denmark, "Copenhagen", 5717014),
            Country(6, "Finland",  R.drawable.flag_finland, "Helsinki", 5491817),
            Country(8, "Germany",  R.drawable.flag_germany, "Berlin", 81770900),
            Country(6, "India", R.drawable.flag_india, "New Delhi", 1295210000),
            Country(8, "Pakistan", R.drawable.flag_pakistan, "Islamabad", 194125062),
        )

        val rec = findViewById<RecyclerView>(R.id.mainRecyclerView)
        rec.layoutManager = LinearLayoutManager(this)

        val adapter = CountryAdapter(countries) { view ->
            val country = view.tag as Country
            var intent = Intent(this, CountryDetailActivity::class.java)
            intent.putExtra("country", country)
            startActivity(intent)
        }
        rec.adapter = adapter
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)

        var msg = ""
        when (newConfig.orientation){
            Configuration.ORIENTATION_LANDSCAPE -> {
                msg = "You are in Landscape Mode"

            }
            Configuration.ORIENTATION_PORTRAIT -> {
                msg = "You are in Portrait Mode"
            }
            else -> {
                msg = "Undefined"
            }
        }

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()


    }
}