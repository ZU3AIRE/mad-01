package com.example.mada01

import android.content.res.Configuration
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.commit


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

        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            supportFragmentManager.setFragmentResultListener(
                "ListenToMe",
                this
            ) { requestKey, bundle ->
                val result = bundle.getParcelable<Country>("selected")
                supportFragmentManager.commit {
                    replace(R.id.viewContainer, CountryDetailFragment.newInstance(result!!))
                    setReorderingAllowed(true)
                    addToBackStack(null)
                }
            }
        } else {
            supportFragmentManager.setFragmentResultListener(
                "ListenToMe",
                this
            ) { requestKey, bundle ->
                val result = bundle.getParcelable<Country>("selected")
                supportFragmentManager.commit {
                    replace(R.id.rightViewContainer, CountryDetailFragment.newInstance(result!!))
                    setReorderingAllowed(true)
                    addToBackStack(null)
                }
            }
        }
    }
}