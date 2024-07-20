package com.example.mada01

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.text.TextUtils.replace
import android.view.View
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.commit
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

        supportFragmentManager.setFragmentResultListener("ListenToMe", this ) { requestKey, bundle ->
            val result = bundle.getParcelable<Country>("selected")
            Toast.makeText(this, result?.name ?: "Hello Buddy", Toast.LENGTH_SHORT).show()
            supportFragmentManager.commit {
                replace(R.id.viewContainer, CountryDetailFragment.newInstance(result!!))
                setReorderingAllowed(true)
                addToBackStack(null)
            }

        }
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