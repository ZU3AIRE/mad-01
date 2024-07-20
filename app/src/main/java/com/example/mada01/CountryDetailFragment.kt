package com.example.mada01

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

private const val COUNTRY = "COUNTRY"

class CountryDetailFragment : Fragment() {
    private var country: Country? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            country = it.getParcelable<Country>(COUNTRY)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_country_detail, container, false)
        view.findViewById<TextView>(R.id.countryDetailName).text = country?.name
        view.findViewById<TextView>(R.id.countryDetailCapital).text = country?.capital
        view.findViewById<TextView>(R.id.countryDetailPopulation).text = country?.population.toString()
        view.findViewById<ImageView>(R.id.dtlFlagImage).setImageResource(country?.flagResourceId ?: 0)
        return view;
    }

    companion object {
        @JvmStatic
        fun newInstance(country: Country) =
            CountryDetailFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(COUNTRY, country)
                }
            }
    }
}