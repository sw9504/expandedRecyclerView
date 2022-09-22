package com.utn.expandedrecyclerview.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.utn.expandedrecyclerview.R
import com.utn.expandedrecyclerview.entities.Instrument
import com.utn.myrecyclerview.adapters.InstrumentAdapter

class listFragment : Fragment() {
    lateinit var v : View
    lateinit var recInstrument: RecyclerView

    var instrumentList : MutableList<Instrument> = mutableListOf()
    lateinit var  adapter: InstrumentAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v =  inflater.inflate(R.layout.fragment_list, container, false)

        recInstrument = v.findViewById(R.id.recInstrument)
        instrumentList.add(Instrument("0","Guitarra","Gibson","null","null"))
        instrumentList.add(Instrument("1","Guitarra","Fender","null","null"))
        instrumentList.add(Instrument("2","Guitarra","Ibanez","null","null"))
        instrumentList.add(Instrument("3","Piano","Cassio","null","null"))

        return v
    }

    override fun onStart() {
        super.onStart()

        adapter = InstrumentAdapter(instrumentList)
        recInstrument.layoutManager = LinearLayoutManager(requireContext())
        recInstrument.adapter = adapter
    }
}