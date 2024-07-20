package com.example.mada01

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CountryListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_country_list, container, false)
        val countries = arrayOf(
            Country(1, "Austria", R.drawable.flag_austria, "Vienna", 8725931),
            Country(2, "Bahrain", R.drawable.flag_bahrain, "Manama", 1404900),
            Country(3, "Belgium", R.drawable.flag_belgium, "Brussels", 11319511),
            Country(4, "Brazil", R.drawable.flag_brazil, "Brasília", 206135893),
            Country(5, "Denmark", R.drawable.flag_denmark, "Copenhagen", 5717014),
            Country(6, "Finland", R.drawable.flag_finland, "Helsinki", 5491817),
            Country(8, "Germany", R.drawable.flag_germany, "Berlin", 81770900),
            Country(6, "India", R.drawable.flag_india, "New Delhi", 1295210000),
            Country(8, "Pakistan", R.drawable.flag_pakistan, "Islamabad", 194125062),
        )

        val rec = view.findViewById<RecyclerView>(R.id.recyclerView)
        if (rec != null) {
            rec.layoutManager = LinearLayoutManager(view.context)
            val adapter = CountryAdapter(countries) {it ->
                val c = it.tag as Country
                val b = Bundle()
                b.putParcelable("selected", c)
                parentFragmentManager.setFragmentResult("ListenToMe", b)
            }
            rec.adapter = adapter
        }

        return view;
    }
}